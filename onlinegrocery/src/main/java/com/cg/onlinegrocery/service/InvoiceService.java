package com.cg.onlinegrocery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.onlinegrocery.domain.Item;
import com.cg.onlinegrocery.repository.InvoiceRepository;

@Service
@Transactional
public class InvoiceService implements MockInvoiceService {

	@Autowired
	InvoiceRepository repository;

	@Override
	public List<Item> getAllitems() {
		return repository.findAll();
	}

}
