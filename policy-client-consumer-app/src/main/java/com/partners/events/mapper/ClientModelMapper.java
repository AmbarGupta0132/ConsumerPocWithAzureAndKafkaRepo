package com.partners.events.mapper;

import com.partners.events.entity.Client;
import com.partners.events.entity.ClientBackup;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/**
 * Component for mapping between {@link Client} and {@link ClientBackup} entities.
 * Utilizes {@link ModelMapper} for object conversion.
 */
@Component
public class ClientModelMapper {

	/** ModelMapper instance for performing object mapping. */
	private final ModelMapper modelMapper;

	/**
	 * Constructs a ClientModelMapper with the provided ModelMapper.
	 *
	 * @param modelMapper the ModelMapper used for mapping entities
	 */
	public ClientModelMapper(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	/**
	 * Maps a {@link Client} entity to a {@link ClientBackup} entity.
	 *
	 * @param from the Client entity to map from
	 * @return the mapped ClientBackup entity
	 */
	public ClientBackup toClientBackup(Client from) {
		return modelMapper.map(from, ClientBackup.class);
	}

	/**
	 * Maps a {@link ClientBackup} entity to a {@link Client} entity.
	 *
	 * @param from the ClientBackup entity to map from
	 * @return the mapped Client entity
	 */
	public Client toClient(ClientBackup from) {
		return modelMapper.map(from, Client.class);
	}

}
