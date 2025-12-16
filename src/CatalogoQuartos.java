import java.util.ArrayList;
import java.util.List;

public class CatalogoQuartos<T extends Quarto>{

    List<T> lista = new ArrayList<>();

    void  adicionar(T item){
        lista.add(item);
    }


    boolean remover(int numero){
        this.lista.removeIf(item -> item.getNumero() == numero);
        return true;
    }
    T buscar(int numero){
      return this.lista.stream().filter(item -> item.getNumero() == numero).findFirst().orElse(null);
    }

//    boolean jaExiste(int numero){
//        return lista.contains(numero);
//    }
    boolean existe(int numero){

        return  this.lista.stream().anyMatch(item -> item.getNumero() == numero);
    }

    void listar(){
        for(T item : this.lista){
            System.out.println(item);

        }
    }


}
