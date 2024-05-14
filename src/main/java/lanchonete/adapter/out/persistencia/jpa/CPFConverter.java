package lanchonete.adapter.out.persistencia.jpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lanchonete.aplicacao.dominio.cliente.CPF;

@Converter
public class CPFConverter implements AttributeConverter<CPF, String> {

    @Override
    public String convertToDatabaseColumn(CPF cpf) {
        if (cpf == null) {
            return null;
        }

        return cpf.toString();
    }

    @Override
    public CPF convertToEntityAttribute(String dbColumnValue) {
        if (dbColumnValue == null || dbColumnValue.isEmpty()) {
            return CPF.NULL;
        }

        return CPF.parse(dbColumnValue);
    }
}