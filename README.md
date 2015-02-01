# Génération de lambda termes pour du test
Projet AAGA "Générateur de lambda-termes pour du test" -- [Sujet](http://www-apr.lip6.fr/~genitrini/doc_ens/td5_M2_AAGA.pdf)

## Termes les plus simples

### Générateur de Boltzmann de types de termes habitables.

On défini la taille d'un type par son nombre de noeuds internes. Cette définition sera conservée pour le reste du document.

Un type est défini par

    Type ::= Int | Type -> Type
  
La série associée est donc

    B(z) = 1 + z B²(z)
    
On obtient

    B(z) = (1-sqrt(1-4z))/2z
    
Le paramètre de Boltzmann `z` est compris strictement entre `0` et `1/4`. En normalisant, on a une probabilité `zB²(z)/(zB²(z)+1)` de générer un noeud interne et une probabilité `1/(zB²(z)+1)` de générer une feuille.
    
### Construction d'un terme de taille minimale habitant un type

On définit les termes de la façon suivante:
    
    Terme ::= x | c | λx:σ.M | M N
    
`x` est une variable et on s'autorise également les constantes de `0` à `10` inclu.

Les termes peuvent, tout comme les types, être représentés sous forme d'un arbre où les noeuds internes représentent une abstraction ou une application.

La taille d'un terme est le nombre de noeuds internes nécessaires pour le représenter sans compter ceux qui représente un type dans le cas de l'abstraction. En effet, le type de la variable faisant le sujet de l'abstraction n'est pas un terme à proprement parler. Il nous a donc semblé judicieux de ne pas compter sa taille lors du calcul de la taille du terme. On conservera cette définition dans le reste du document.

Pour un type donné, on n'utilise pas les applications pour avoir un terme de taille minimale.

### Construction d'un terme de taille donnée habitant un type

Pour un type `T1` donné et une taille minimale de terme `m` donnée, on génère un terme du type `T2 -> T1` où `T2` est suffisamment grand pour que la somme des tailles des types atteigne `m`. On ajoute ensuite une abstraction avec un terme de type `T2` pour retrouver un terme de type `T1` de taille au moins `m`.
    
## Termes enrichis

### Des termes simples, et d'autres un peu plus construits

La constante `0` est trivialement de type `Int` mais également le terme suivant: `λx:Int.λy:Int.x+y 10 12`.

`λx:Int.x+2` est de type `Int->Int`.

`λx:Int.λy:Int.x+y` est de type `Int->Int->Int`.

### Générateur de Boltzmann de types de termes habitables

On choisit de conserver la représentation des types définie précédemment.

<!-- Expliquer pourquoi on peut se passer de flèche+ et flèche- -->

### Construction d'un terme de taille minimale habitant un type

Comme précédemment, on représente les termes sous forme d'arbre. En plus des abstractions et des applications, les noeuds internes peuvent aussi représenter une addition ou alors l'opposé d'une constante.
   
    Terme ::= x | c | λx:σ.M | M N | M + N | -M

Pour la génération d'un terme de taille minimale, on ne va pas utiliser ces éléments qui ajoute de nouveaux noeuds internes (et donc augmente la taille), sans permettre de matcher de nouveaux types. On garde donc la génération des termes simples.

### Construction d'un terme de taille donnée habitant un type

Précédemment, pour agrandir un terme tout en conservant son type, l'ajout d'un application était la seule possibilité. Avec cette nouvelle grammaire, on peut également agrandir le terme au niveau des feuilles en ajoutant des opérations `+` et `-`.

## Termes riches

### Des termes simples, et d'autres un peu plus construits

La constante `0` est trivialement de type `Int` mais également le terme suivant: `(λx:List[Int].head x) (cons 9 [])`.

### Générateur de Boltzmann de types de termes habitables

On ajoute le type `List[Int]` à la précédente définition.

    Type ::= Int | List[Int] | Type -> Type
  
La série associée est donc

    B(z) = 1 + 1 + z B²(z)
    
On obtient

    B(z) = (1-sqrt(1-8z))/2z
    
Le paramètre de Boltzmann `z` est compris strictement entre `0` et `1/8`. En normalisant, on a une probabilité `zB²(z)/(zB²(z)+2)` de générer un noeud interne et une probabilité `1/(zB²(z)+2)` de générer chaque feuille.

### Construction d'un terme de taille minimale habitant un type

On considère maintenant les termes suivants, ainsi que la liste vide dans les constantes.
   
    Terme ::= x | c | λx:σ.M | M N | M + N | -M | head M | tail M | cons M
    
Les nouveaux éléments de la grammaire ajoutent de nouvelles possibilités pour les nœuds internes, sauf la constante `nil`. Étant donné que nous souhaitons ici générer des termes de taille minimale, nous utiliserons uniquement cette nouvelle constante pour matcher le type `List[Int]`.

### Construction d'un terme de taille donnée habitant un type

On utilise la même méthode que précedemment, en ajoutant les possibilités offertes par les listes:, `cons`, `head` et `tail`. Dans le cas de ces deux derniers, on génère immédiatement un `cons` avec pour ne pas se préoccuper de la taille. On évite ainsi de faire un `head` sur une liste vide.

## Bilan

La solution produite permet de générer tous les types et de générer pour chaque type une infinité de termes l'habitant. Cependant, la génération de termes n'est pas exhaustive. En particulier en ce qui concerne les applications. En effet, on ne génère des applications que lorsque le type à matcher est une flèche et on génère le paramètre indépemment du reste. Avec notre générateur actuel, on ne génère par exemple `λf;Int->Int. λx:Int. (f x).
Il arrive également, raremenent, que des StackOverflowError surviennent. Nous supposons que l'origine du problème pourrait être un type ou un terme trop imposant. Mais cette erreur n'intervenant que rarement, nous avons décidé de ne pas la traiter.