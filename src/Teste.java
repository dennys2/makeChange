public class Teste {

    private int quarters = 0;
    private int dimes = 0;
    private int nickels = 0;
    private int pennies = 0;
    private Set<int[]> conjunto = new Set<>();

    public static void main(String[] args) {
        Teste t = new Teste();
        t.makeChange(12).print();
    }

    /*
        Invoca o método calculate
        Retorna o atributo conjunto do tipo Set
     */
    public Set<int[]> makeChange(int n) {
        calculate(n);
        return this.conjunto;
    }

    /*
        Invoca os métodos necessários para calcular a quantidade de moedas para
        cada valor
     */
    public void calculate(int n) {
        getMaxPennies(n);
        getMaxNickels(n);
        getMaxDimesFromNickels(n);
        getMaxDimesFromPennies(n);
        getMaxQuarters(n);
    }

    /*
        Recebe n como parâmetro e atribui a quantidade de pennies
        Adiciona ao conjunto
     */
    private void getMaxPennies(int n) {
        this.pennies = n;
        conjunto.add(getCoins());
    }

    /*
        Recebe n como parâmetro e calcula a quantidade de dimes de acordo com a quantidade de pennies
        Itera de acordo com o valor de nickels
        Adiciona ao conjunto a cada iteração
     */
    private void getMaxNickels(int n) {
        int aux = n;
        while (aux >= 5) {
            this.pennies = this.pennies - 5;
            aux = aux - 5;
            this.nickels++;
            conjunto.add(getCoins());
        }
    }

    /*
        Recebe n como parâmetro e calcula a quantidade de dimes de acordo com a quantidade de nickels
        Itera de acordo com o valor de dimes
        Adiciona ao conjunto a cada iteração
     */
    private void getMaxDimesFromNickels(int n) {
        int aux = n;
        while (aux >= 10) {
            if (this.nickels >= 2) {
                this.nickels = this.nickels - 2;
                this.dimes++;
                conjunto.add(getCoins());
            }
            aux = aux - 10;
        }
    }

    /*
        Recebe n como parâmetro e calcula a quantidade de dimes de acordo com a quantidade de pennies
        Itera de acordo com o valor de dimes
        Adiciona ao conjunto a cada iteração
        Invoca getMaxNickels novamente para recalcular a quantidade de nickels de acordo com a nova quantidade de pennies
     */
    private void getMaxDimesFromPennies(int n) {
        int aux = n;
        this.dimes = 0;
        this.nickels = 0;
        getMaxPennies(n);
        while (aux >= 10) {
            if (this.pennies >= 10) {
                this.pennies = this.pennies - 10;
                this.dimes++;
                conjunto.add(getCoins());
                getMaxNickels(this.pennies);
            }
            aux = aux - 10;
        }
    }

    /*
        Recebe n como parâmetro e calcula a quantidade de quarters
        Itera de acordo com o valor de quarters
        Invoca getMaxDimesFromPennies, pois esse método também já recalcula a quantidade de nickels e pennies
        Adiciona ao conjunto a cada iteração
     */
    private void getMaxQuarters(int n) {
        int aux = n;
        while (aux >= 25) {
            this.nickels = 0;
            this.dimes = 0;
            this.quarters++;
            aux = aux - 25;
            getMaxDimesFromPennies(aux);
            conjunto.add(getCoins());
        }
    }

    /*
        Retorna um array de inteiro contendo os valores das variáveis
     */
    private int[] getCoins() {
        return new int[] {this.quarters, this.dimes, this.nickels, this.pennies};
    }

    private void print() {
        System.out.println(quarters + ", " +  dimes + ", " + nickels + ", " + pennies);
    }
}
