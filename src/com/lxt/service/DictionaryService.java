package com.lxt.service;

import java.util.List;
import com.lxt.model.Dictionary;

public interface DictionaryService {
	
	public List<Dictionary> queryAll() throws ServiceException;
}
