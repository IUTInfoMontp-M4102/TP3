# TP3 - Calculs distribués

Ce TP est une illustration des applications qui utilisent des calculs distribués pour les accélérer.

## Multiplication de matrices

**Rappels :** Le produit de deux matrices ne peut se définir que si le nombre de colonnes de la première matrice est le même que le nombre de lignes de la deuxième matrice, c’est-à-dire lorsqu’elles sont de tailles compatibles.

Si _A_ = (_a<sub>ij</sub>_) est une matrice de dimensions (_m_, _n_) et _B_ = (_b<sub>ij</sub>_) est une matrice de dimensions (_n_, _p_), alors leur produit, noté _AB_ = (_c<sub>ij</sub>_) est une matrice de dimensions (_m_, _p_) donnée par :
<div align="center"><img src="https://latex.codecogs.com/svg.image?\forall&space;i,j,&space;\quad&space;c_{ij}&space;=&space;\sum_{k=1}^{n}a_{ik}b_{kj}" title="produit matrices" /></div>

1. Regardez la classe `Matrix` fournie, qui permet de manipuler des matrices d'entiers.

2. Complétez la méthode `times(Matrix B)` de la classe `Matrix`. Testez votre méthode sur des exemples.

Le produit de deux matrices peut être calculé _par blocs_ en utilisant la formule suivante[^1] :

Si on considère les matrices

<div align="center"><img src="https://latex.codecogs.com/svg.image?M=\left(\begin{array}{cc}A&B\\C&D\end{array}\right)\qquad{}N=\left(\begin{array}{cc}A'&B'\\C'&D'\end{array}\right)" title="produit matrices" /></div>

où _A_, _A'_, _B_, _B'_, _C_, _C'_, _D_ et _D'_ sont des (sous-)matrices telles que
- le nombre de colonnes de _A_ et _C_ est égal au nombre de lignes de _A'_ et _B'_
- le nombre de colonnes de _B_ et _D_ est égal au nombre de lignes de _C'_ et _D'_

On a alors le produit
<div align="center"><img src="https://latex.codecogs.com/svg.image?M.N=\left(\begin{array}{cc}AA'+BC'&AB'+BD'\\CA'+DC'&CB'+DD'\end{array}\right)" title="produit matrices" /></div>

Cette décomposition permet de calculer le produit de façon distribuée.

2. Proposez une méthode qui calcule le produit selon une décomposition en blocs des opérandes, en parallélisant les calculs indépendants.

    **Indication :** Vous pouvez définir une tâche qui calcule le produit de deux sous-matrices (par exemple en fournissant les matrices initiales et les sous-intervalles à considérer), et utiliser une tâche principale qui appelle 8 tâches pour faire les sous-produits et construit la matrice finale lorsque les tâches sont complétées.

3. Si on définit la complexité d'une multiplication de matrices comme étant le nombre d'opérations arithmétiques élémentaires (additions et multiplications de nombres) exécutées, quel est la complexité de la multiplication de deux matrices _n_×_n_ par l'algorithme classique (sans parallélisme) ? 

4. Dans le cas distribué, si on suppose que les tâches sont exécutées en parallèle, la complexité est le nombre d'opérations élémentaires du plus long "chemin d'exécution" (c'est-à-dire la complexité de la sous-tâche la plus longue, plus la complexité de la tâche principale qui regroupe les résultats). Quelle est alors la complexité de la multiplication de deux matrices _n_×_n_ par l'algorithme distribué ?

[^1]: Réf: [Produit matriciel](https://fr.wikipedia.org/wiki/Produit_matriciel) sur Wikipédia
