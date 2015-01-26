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
    
En normalisant, on a une probabilité `B(z)/(B(z)+1)` de générer un noeud interne et une probabilité `1/(B(z)+1)` de générer une feuille.

<!-- Ajouter la contrainte sur z -->
    
### Construction d'un terme de taille minimale habitant un type

On définit les termes de la façon suivante:
    
    Terme ::= x | λx:σ.M | M N
    
`x` est une variable et on s'autorise également les constantes de 0 à 10 inclu.

Les termes peuvent, tout comme les types, être représentés sous forme d'un arbre où les noeuds internes représentent une abstraction ou une application.

<!-- Expliquer comment on représente chaque élément sous forme d'arbre -->

### Construction d'un terme de taille donnée habitant un type
    
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

### Construction d'un terme de taille minimale habitant un type

### Construction d'un terme de taille donnée habitant un type
