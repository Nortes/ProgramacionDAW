public class Impresora {

    private int toner;
    private int paginasImpresas;
    private final boolean dobleCara;

    public Impresora(boolean dobleCara){
        this.toner=0;
        this.paginasImpresas=0;
        this.dobleCara=dobleCara;
    }

    public int rellenaToner (int toner){
        if(toner<0||toner>100){
            return -1;
        }
        if(this.toner+toner>100){
            return -1;
        }
        else {
            this.toner+=toner;
            return this.toner;
        }
    }

    public int imprime (int paginas){
        int hojas;

        if(paginas<0){
            hojas=0;
            System.out.println("No se ha podido realizar su pedido. La impresión ha fallado");
        }
        else {
            if (this.dobleCara) {
                if (paginas % 2 == 0) {
                    hojas = paginas / 2;
                } else {
                    hojas = paginas / 2 + 1;
                }
            } else {
                hojas = paginas;
            }
        }
        if(this.toner-hojas<0){
            System.out.println("Falta toner, rellene la impresora");
            return -1;
        }
        else{
            this.toner-=hojas;
            this.paginasImpresas += hojas;
            return hojas;
        }
    }

    public int getPaginasImpresas(){
        return this.paginasImpresas;
    }

    public int getToner(){
        return this.toner;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
