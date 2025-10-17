#include "MaxStack.h"

bool MaxStack::empty() const{
    return valores.empty();
}


void MaxStack::push(int x){
    if (this->empty()) {
        celda c={x,x};
        valores.push(c);
    }
    else {
        int maximo=this->max();
        if(x>this->max()) {
            maximo=x;
        }
        celda c={x,maximo};
        valores.push(c);
    }
}

void MaxStack::pop(){
    if(!this->empty()){
        this->disminuir();
    }
}

int MaxStack::max() const{
    if (!this->empty())
    return valores.back().maximo;
    throw "Stack vacio";

}

int MaxStack::top() const{
    if (!this->empty())
    return valores.back().valor;
    throw "Stack vacio";
}

int MaxStack::size() const{
    return valores.size();
}

MaxStack::MaxStack()
{
}

MaxStack::~MaxStack()
{
}

celda MaxStack::disminuir() {
    celda c;
    queue<celda> aux;
    while(this->size()!=1){
        aux.push(valores.front());
        valores.pop();
    }
    c=valores.front();
    valores.pop();
    while (!aux.empty()) {
        valores.push(aux.front());
        aux.pop();
    }
    return c;
}
