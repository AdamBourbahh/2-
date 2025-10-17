#ifndef MAXSTACK_H
#define MAXSTACK_H
/**
El MaxStack se especifica como un contenedor LIFO que además tiene la funcionalidad de almacenar el máximo.
Se destaca por las siguientes operaciones:
  -push(x): almacena x en el tope del contenedor.
  -pop(): quita el elemento tope del contenedor.
  -empty(): dice si el contenedor está o no vacío.
  -size(): devuelve el número de elementos almacenados.
  -max(): devuelve el máximo del contenedor.
  -top(): devuelve el valor tope del contenedor.
**/


#include <iostream>
#include <queue>
using namespace std;

struct celda {
    int valor;
    int maximo;
};

class MaxStack
{
public:
    MaxStack();
    virtual ~MaxStack();
    bool empty() const;
    void push(int x);
    void pop();
    int top() const;
    int max() const;
    int size() const;
private:
    queue<celda> valores;
    celda disminuir();
};

#endif // MAXSTACK_H