package com.pucp.aevent.service;

import com.pucp.aevent.entity.FormularioCFP;
import com.pucp.aevent.entity.response_objects.Error;

public interface IFormularioCFPService {
	
	Error getError();
	
	public void save(FormularioCFP formularioCFP);
}
