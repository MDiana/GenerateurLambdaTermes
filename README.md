# Génération de lambda termes pour du test
Projet AAGA "Générateur de lambda-termes pour du test"

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

Pour un type donné, la taille minimal d'un terme est celle du type. On n'utilise pas les applications dans ce cas.

### Construction d'un terme de taille donnée habitant un type

Pour un type `T1` donné et une taille `m` donnée, on génère un terme du type `T2 -> T1` où `T2` est suffisamment grand pour que la somme des types atteigne `m`. On ajoute ensuite une abstraction avec un terme de type `T2` pour retrouver un terme de type `T1` de taille au moins `m`.
    
## Termes enrichis

### Des types simples, et d'autres un peu plus construits

La constante `0` est trivialement de type `Int` mais également le terme suivant: `λx:Int.λy:Int.x+y 10 12`.

`λx:Int.x+2` est de type `Int->Int`.

`λx:Int.λy:Int.x+y` est de type `Int->Int->Int`.

### Générateur de Boltzmann de types de termes habitables

On choisit de conserver la représentation des types définie précédemment.

<!-- Expliquer pourquoi on peut se passer de flèche+ et flèche- -->

### Construction d'un terme de taille minimale habitant un type

Comme précédemment, on représente les termes sous forme d'arbre. En plus des abstractions et des applications, les noeuds internes peuvent aussi représenter une addition ou alors l'opposé.

La taille d'un terme est le nombre de noeuds internes nécessaires pour le représenter sans compter ceux qui représente un type dans le cas de l'abstraction.

La série associée est:

    T(z) = 1 + z Abs(z) + z App(z) + z Add(z) + z Opp(z)
    Abs(z) = T(z)
    App(z) = T²(z)
    Add(z) = T²(z)
    Opp(z) = T(z)

### Construction d'un terme de taille donnée habitant un type

## Termes riches

### Des types simples, et d'autres un peu plus construits

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

### Construction d'un terme de taille donnée habitant un type
