package lanchonete.aplicacao.dominio.cliente;

import java.io.Serializable;
import java.util.Objects;

public final class CPF implements Comparable<CPF>, Serializable {
	private static final long serialVersionUID = 1L;
	public static final CPF NULL = new CPF();
	private String numero;
	
	
	private CPF() {
		this.numero = "";
	}
	private CPF(String numeroValidado) {
		this.numero = numeroValidado;
	}
	
	public static CPF of(String valor) {
		if (valor == null || valor.isBlank() || valor.isEmpty())
			return NULL;
		
		valor = valor.trim();
		
        // considera-se erro CPF"s formados por uma sequencia de numeros iguais
        if ((valor.length() != 11))
            throw new CPFInvalido("O número deve ter exatamente 11 dígitos");

        if (valor.equals("00000000000") || valor.equals("11111111111") ||
        	valor.equals("22222222222") || valor.equals("33333333333") ||
        	valor.equals("44444444444") || valor.equals("55555555555") ||
        	valor.equals("66666666666") || valor.equals("77777777777") ||
        	valor.equals("88888888888") || valor.equals("99999999999")
            )
            throw new CPFInvalido("Números iguais");
		
        char dig10, dig11;
        int sm, i, r, num, peso;

        try {
        	// Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
            	// converte o i-esimo caractere da string passada em um numero:
            	// por exemplo, transforma o caractere "0" no inteiro 0
            	// (48 eh a posicao de "0" na tabela ASCII)
            	num = (int)(valor.charAt(i) - 48);
            	sm = sm + (num * peso);
            	peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

            // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            	num = (int)(valor.charAt(i) - 48);
            	sm = sm + (num * peso);
            	peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == valor.charAt(9)) && (dig11 == valor.charAt(10)))
            	return new CPF(valor);
        
        } catch (Exception e) {
            throw new CPFInvalido("dígito verificador inválido");
		}
        
        throw new CPFInvalido("dígito verificador inválido");
	}
	
	public static CPF parse(String valor) {
		try {
			return of(valor);
		} catch (Exception e) {
			return CPF.NULL;
		}
	}
	
	public boolean isNull() {
		return numero.isEmpty();
	}
	
	@Override
	public int compareTo(CPF o) {
		return this.numero.compareTo(o.numero);
	}
	
    public String toString() {
    	if (isNull())
    		return "";
   		return(numero.substring(0, 3) + "." + numero.substring(3, 6) + "." + numero.substring(6, 9) + "-" + numero.substring(9, 11));
    }
    
	@Override
	public int hashCode() {
		return Objects.hash(numero);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CPF other = (CPF) obj;
		return Objects.equals(numero, other.numero);
	}	

}
