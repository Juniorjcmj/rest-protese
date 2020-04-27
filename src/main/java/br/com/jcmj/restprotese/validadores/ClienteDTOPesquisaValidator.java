package br.com.jcmj.restprotese.validadores;

import br.com.jcmj.restprotese.dto.ClienteDTO;
import br.com.jcmj.restprotese.exceptions.FieldMessage;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClienteDTOPesquisaValidator implements ConstraintValidator<ClienteDTOPesquisa, ClienteDTO> {

    @Override
    public void initialize(ClienteDTOPesquisa ann) {

    }

    @Override
    public boolean isValid(ClienteDTO objDTO, ConstraintValidatorContext context) {

        //Map<String, String>map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        //Integer uriId = Integer.parseInt(map.get("id"));
        List<FieldMessage> list = new ArrayList<>();

        if (objDTO.getNome().length() < 5) {
            list.add(new FieldMessage("Nome", "Nome Deve possuir mais de 5 caracteres"));
        }
        if (objDTO.getNome() == null) {
            list.add(new FieldMessage("Nome", "Nome é obrigatório"));
        }
        if (objDTO.getStatus() == null) {
            list.add(new FieldMessage("status", "Status é obrigatório"));
        }
        if (objDTO.getDataInicio() == null) {
            list.add(new FieldMessage("dataInicio", "Data inicio  é obrigatória"));
        }
        if (objDTO.getDataFim() == null) {
            list.add(new FieldMessage("dataFim", "Data Fim  é obrigatória"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
