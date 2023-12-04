package com.w3g.calculaimc;

public class IMC {
 

    private String classificacao;
    private final float peso;
    private final float altura;
    private float resultado;
    
    public IMC(float peso, float altura) {
        this.peso = peso;
        this.altura = altura;
    }
    public float getResultado() {
        return resultado;
    }
    public void CalculaIMC (){
        this.resultado = this.peso/(this.altura*this.altura);
    }
    public  void classificar(){
        if (this.resultado < 18.5){
            this.classificacao = "Baixo peso";
        } else if ( this.resultado >= 18.5 && this.resultado
                <= 24.9    ) {
            this.classificacao = "Peso Normal";

        }  else if ( this.resultado >= 25 && this.resultado
                <= 29.9    ) {
            this.classificacao = "Sobrepeso";

        }  else if ( this.resultado >= 30 && this.resultado
                <= 34.9    ) {
            this.classificacao = "Obesidade grau I";

        }  else if ( this.resultado >= 35 && this.resultado
                <= 39.9    ) {
            this.classificacao = "Obesidade grau II";

        }  else if ( this.resultado > 40) {
            this.classificacao = "Obesidade grau III";

        }
    }

    public String getClassificacao() {
        return this.classificacao;
    }
}
