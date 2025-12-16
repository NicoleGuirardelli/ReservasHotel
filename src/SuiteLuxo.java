public class SuiteLuxo extends Quarto{
    public SuiteLuxo(int numero, String descricao, double valorDiaria) {
        super(numero, descricao, valorDiaria);
    }
    private boolean hidro;

    @Override
    void aplicarDesconto(double percentual) {
        if(percentual>30||percentual<0){
        throw new IllegalArgumentException("O desconto deve ser de até 15%");
    }
        valorDiaria = valorDiaria * percentual/100;

    }
    @Override
    public String toString() {
        return super.toString()+"Hidro: "+hidro;
    }
}
