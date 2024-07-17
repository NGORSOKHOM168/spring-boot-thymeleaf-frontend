package com.learning.service.impl;

import org.springframework.stereotype.Service;

import com.learning.entity.Sequence;
import com.learning.repository.SequenceRepository;
import com.learning.service.SequenceService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SequenceServiceImpl implements SequenceService{
	
	private final SequenceRepository sequenceRepository;

	@Override
	public String stringId12digits(String tableName) {
		Sequence sequence  = sequenceRepository.findByTableName(tableName);		
		if(sequence != null) {
			String seqPrefix = sequence.getSeqPrefix().toUpperCase();
			Long seqNumber = Long.valueOf(sequence.getSeqNumber()+1);	
			sequence.setSeqNumber(seqNumber);
			sequenceRepository.save(sequence);
			return String.valueOf(seqPrefix+seqNumber);
		}		
		String seqPrefix = tableName.substring(0,2).toUpperCase();
		Long seqNumber = Long.valueOf(2024000001);
		Sequence newSeq = Sequence.builder().seqPrefix(seqPrefix).seqNumber(seqNumber).tableName(tableName).build();
		sequenceRepository.save(newSeq);		
		return String.valueOf(seqPrefix+seqNumber);
	}

}
