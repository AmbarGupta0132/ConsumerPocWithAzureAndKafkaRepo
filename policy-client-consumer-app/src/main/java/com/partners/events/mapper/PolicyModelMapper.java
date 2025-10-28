package com.partners.events.mapper;

import com.partners.events.entity.Policy;
import com.partners.events.entity.PolicyBackup;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
/**
 * Component for mapping between {@link Policy} and {@link PolicyBackup} entities.
 * Utilizes {@link ModelMapper} for object conversion.
 */
@Component
public class PolicyModelMapper {

	/** ModelMapper instance for performing object mapping. */
	private final ModelMapper modelMapper;

	/**
	 * Constructs a PolicyModelMapper with the provided ModelMapper.
	 *
	 * @param modelMapper the ModelMapper used for mapping entities
	 */
	public PolicyModelMapper(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	/**
	 * Maps a {@link Policy} entity to a {@link PolicyBackup} entity.
	 *
	 * @param from the Policy entity to map from
	 * @return the mapped PolicyBackup entity
	 */
	public PolicyBackup toPolicyBackup(Policy from) {
		return modelMapper.map(from, PolicyBackup.class);
	}

	/**
	 * Maps a {@link PolicyBackup} entity to a {@link Policy} entity.
	 *
	 * @param from the PolicyBackup entity to map from
	 * @return the mapped Policy entity
	 */
	public Policy toPolicy(PolicyBackup from) {
		return modelMapper.map(from, Policy.class);
	}
}