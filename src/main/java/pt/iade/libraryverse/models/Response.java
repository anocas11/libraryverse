package pt.iade.libraryverse.models;

import java.util.List;

//foi criada uma classe com uma propriedade results com tipo dinamico para conseguir trabalhar melhor com o http client dado em aula
public class Response<T> {
    public T results;
}
