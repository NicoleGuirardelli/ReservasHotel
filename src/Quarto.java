abstract class Quarto implements Reservavel{
    protected int numero;
    protected String descricao;
    protected double valorDiaria;

    public Quarto(int numero, String descricao, double valorDiaria) {
        this.numero = numero;
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
    }

    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    @Override
    public void reservar(int dias) {
        System.out.println("Quarto: "+ getClass().getName()+", número: "+getNumero()+", reservada por "+ dias);
    }

    @Override
    public double calcularValorTotal(int dias) {
        return valorDiaria * dias;
    }
    abstract void aplicarDesconto(double percentual);

    @Override
    public String toString() {
        return "Quarto{" +
                "numero=" + numero +
                ", descricao='" + descricao + '\'' +
                ", valorDiaria=" + valorDiaria +
                '}';
    }
}
