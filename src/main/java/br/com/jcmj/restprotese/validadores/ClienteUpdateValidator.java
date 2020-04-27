package br.com.jcmj.restprotese.validadores;

import br.com.jcmj.restprotese.exceptions.FieldMessage;
import br.com.jcmj.restprotese.model.Servico;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ClienteUpdateValidator implements ConstraintValidator<ServicoUpdate,Servico > {
	
	@Override
	public void initialize(ServicoUpdate ann) {
			}
	@Override
	public boolean isValid(Servico objDTO, ConstraintValidatorContext context) {		
		
				
		List<FieldMessage>list = new ArrayList<>();	
						
//		if(objDTO.getCliente().getId() == null ) {
//			list.add(new FieldMessage("tipoServico", "Tipo de servico é obrigatório"));
//		}
//		if(objDTO.getTipoServico().getId()==null) {
//			list.add(new FieldMessage("cliente", "Dentista é obrigatório"));
//		}
		
		
		
			for(FieldMessage e : list) {
				context.disableDefaultConstraintViolation();
				context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
			}
		return list.isEmpty();
	}
}
