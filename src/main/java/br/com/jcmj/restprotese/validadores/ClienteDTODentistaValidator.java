package br.com.jcmj.restprotese.validadores;

import br.com.jcmj.restprotese.dto.ClienteDTODentista;
import br.com.jcmj.restprotese.exceptions.FieldMessage;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteDTODentistaValidator implements ConstraintValidator<ClienteDTODentistaV, ClienteDTODentista> {

    @Override
    public void initialize(ClienteDTODentistaV ann) {

    }

    @Override
    public boolean isValid(ClienteDTODentista objDTO, ConstraintValidatorContext context) {

        //Map<String, String>map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        //Integer uriId = Integer.parseInt(map.get("id"));
        List<FieldMessage> list = new ArrayList<>();

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
