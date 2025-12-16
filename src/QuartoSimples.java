public class QuartoSimples extends Quarto {

    private boolean visitaMar;
    public QuartoSimples(int numero, String descricao, double valorDiaria) {
        super(numero, descricao, valorDiaria);
    }


    @Override
    void aplicarDesconto(double percentual) {
        if(percentual>15||percentual<0){
            throw new IllegalArgumentException("O desconto deve ser de até 15%");
        }
        valorDiaria = valorDiaria * percentual/100;

    }

    @Override
    public String toString() {
        return super.toString()+"Vista para mar"+visitaMar;
    }
}
