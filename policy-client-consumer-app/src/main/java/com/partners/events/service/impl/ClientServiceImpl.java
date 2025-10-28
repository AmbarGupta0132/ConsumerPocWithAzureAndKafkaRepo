package com.partners.events.service.impl;

import com.partners.events.entity.Client;
import com.partners.events.entity.ClientBackup;
import com.partners.events.mapper.ClientModelMapper;
import com.partners.events.model.ClientId;
import com.partners.events.repo.ClientBackupRepository;
import com.partners.events.repo.ClientRepository;
import com.partners.events.service.ClientService;
import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
/**
 * Service implementation for managing {@link Client} entities.
 * Provides CRUD operations, Excel export, and backup functionality.
 */
@Service
public class ClientServiceImpl implements ClientService {

	/** Logger for this class. */
	private static final Logger log = LoggerFactory.getLogger(ClientServiceImpl.class);

	/** Repository for {@link Client} persistence operations. */
	private ClientRepository clientRepository;
	/** Repository for {@link ClientBackup} persistence operations. */
	private ClientBackupRepository clientBackupRepository;
	/** Mapper for converting between {@link Client} and {@link ClientBackup}. */
	private ClientModelMapper clientModelMapper;

	/**
	 * Default constructor.
	 */
	public ClientServiceImpl() {
		super();
	}

	/**
	 * Constructs a ClientServiceImpl with the provided repositories and mapper.
	 *
	 * @param clientRepository repository for client entities
	 * @param clientBackupRepository repository for client backup entities
	 * @param clientModelMapper mapper for client and backup conversion
	 */
	@Autowired
	public ClientServiceImpl(ClientRepository clientRepository, ClientBackupRepository clientBackupRepository,
			ClientModelMapper clientModelMapper) {
		this.clientRepository = clientRepository;
		this.clientBackupRepository = clientBackupRepository;
		this.clientModelMapper = clientModelMapper;
	}

	/**
	 * Saves a {@link Client} entity to the database.
	 *
	 * @param client the client entity to save
	 * @return the saved {@link Client} entity
	 */
	@Override
	public Client save(Client client) {
		return clientRepository.save(client);
	}

	/**
	 * Retrieves all {@link Client} entities.
	 *
	 * @return a list of all clients
	 */
	@Override
	public List<Client> findAll() {
		return clientRepository.findAll();
	}

	/**
	 * Finds a {@link Client} by its ID.
	 *
	 * @param id the client ID
	 * @return an {@link Optional} containing the client if found
	 */
	@Override
	public Optional<Client> getById(ClientId id) {
		return clientRepository.findById(id);
	}

	/**
	 * Finds the most recent {@link Client} by client ID.
	 *
	 * @param clientId the client ID
	 * @return an {@link Optional} containing the last client if found
	 */
	@Override
	public Optional<Client> findLastClientByClientId(Long clientId) {
		List<Client> allByIdClientId = clientRepository.findAllByIdClientId(clientId);
		return !allByIdClientId.isEmpty() ? Optional.of(allByIdClientId.getLast()) : Optional.empty();
	}

	/**
	 * Downloads all client data as an Excel file.
	 *
	 * @return a {@link ResponseEntity} containing the Excel file as a {@link Resource}
	 */
	@Override
	public ResponseEntity<Resource> downloadConsumerExcel() {
		List<Client> clients = findAll();

		try (Workbook workbook = new XSSFWorkbook()) {
			Sheet sheet = workbook.createSheet("Clients");
			Row header = sheet.createRow(0);

			String[] columns = { "Client ID", "Status", "Title", "Forename", "Surname", "Gender", "Date of Birth",
					"Occupation", "Preferred Risk Code", "Address Type Code", "Line1", "Line2", "Line3", "Line4",
					"Suburb", "City", "Country", "Post Code", "Primary", "Email", "Mobile Phone", "Home Phone",
					"Business Phone", "Comments", "Created Date", "Modified Date", "Version" };

			for (int i = 0; i < columns.length; i++) {
				header.createCell(i).setCellValue(columns[i]);
			}

			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

			int rowIdx = 1;
			for (Client client : clients) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(
						client.getId().getClientId() != null ? client.getId().getClientId().toString() : "");
				row.createCell(1).setCellValue(client.getStatus() != null ? client.getStatus() : "");
				row.createCell(2).setCellValue(client.getTitle() != null ? client.getTitle() : "");
				row.createCell(3).setCellValue(client.getForename() != null ? client.getForename() : "");
				row.createCell(4).setCellValue(client.getSurname() != null ? client.getSurname() : "");
				row.createCell(5).setCellValue(client.getGender() != null ? client.getGender() : "");
				row.createCell(6).setCellValue(
						client.getDateOfBirth() != null ? client.getDateOfBirth().format(dateFormatter) : "");
				row.createCell(7).setCellValue(client.getOccupation() != null ? client.getOccupation() : "");
				row.createCell(8)
						.setCellValue(client.getPreferredRiskCode() != null ? client.getPreferredRiskCode() : "");
				row.createCell(9).setCellValue(client.getAddressTypeCode() != null ? client.getAddressTypeCode() : "");
				row.createCell(10).setCellValue(client.getLine1() != null ? client.getLine1() : "");
				row.createCell(11).setCellValue(client.getLine2() != null ? client.getLine2() : "");
				row.createCell(12).setCellValue(client.getLine3() != null ? client.getLine3() : "");
				row.createCell(13).setCellValue(client.getLine4() != null ? client.getLine4() : "");
				row.createCell(14).setCellValue(client.getSuburb() != null ? client.getSuburb() : "");
				row.createCell(15).setCellValue(client.getCity() != null ? client.getCity() : "");
				row.createCell(16).setCellValue(client.getCountry() != null ? client.getCountry() : "");
				row.createCell(17).setCellValue(client.getPostCode() != null ? client.getPostCode() : "");
				row.createCell(18).setCellValue(client.getPrimary() != null ? client.getPrimary().toString() : "");
				row.createCell(19).setCellValue(client.getEmail() != null ? client.getEmail() : "");
				row.createCell(20).setCellValue(client.getMobilePhone() != null ? client.getMobilePhone() : "");
				row.createCell(21).setCellValue(client.getHomePhone() != null ? client.getHomePhone() : "");
				row.createCell(22).setCellValue(client.getBusinessPhone() != null ? client.getBusinessPhone() : "");
				row.createCell(23).setCellValue(client.getComments() != null ? client.getComments() : "");
				row.createCell(24).setCellValue(
						client.getCreatedDate() != null ? client.getCreatedDate().format(dateTimeFormatter) : "");
				row.createCell(25).setCellValue(
						client.getModifiedDate() != null ? client.getModifiedDate().format(dateTimeFormatter) : "");
				row.createCell(26).setCellValue(
						client.getId().getVersion() != null ? client.getId().getVersion() : "");

			}

			ByteArrayOutputStream out = new ByteArrayOutputStream();
			workbook.write(out);
			ByteArrayResource resource = new ByteArrayResource(out.toByteArray());

			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=clients.xlsx");

			return ResponseEntity.ok().headers(headers).contentLength(resource.contentLength())
					.contentType(MediaType
							.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
					.body(resource);

		} catch (IOException e) {
			log.error(e.getMessage());
			throw new RuntimeException("Failed to generate Excel file", e);
		}
	}

	/**
	 * Saves a client and backs up the previous version if it exists.
	 * The previous client is backed up and deleted before saving the new client.
	 *
	 * @param client the client entity to save
	 * @return an {@link Optional} containing the saved client
	 * @throws RuntimeException if backup or save fails
	 */
	@Transactional
	@Override
	public Optional<Client> saveClientAndClientBackup(Client client) {
		try {
			String version = "v" + (Integer.parseInt(client.getId().getVersion().substring(1))-1);
			ClientId clientId = new ClientId(client.getId().getClientId(), version);
			Optional<Client> optionalClient = getById(clientId);
			if (optionalClient.isPresent()) {
				Client previousClient = optionalClient.get();
				ClientBackup savedClientBackup = clientBackupRepository
						.save(clientModelMapper.toClientBackup(previousClient));
                clientRepository.deleteById(previousClient.getId());
            }
			return Optional.of(clientRepository.save(client));
		} catch (Exception e) {
			log.error("Error saving client and backup: {}", e.getMessage(), e);
			throw new RuntimeException("Client is not updated with given value: " + client, e);
		}
	}

	/**
	 * Retrieves all {@link Client} entities with pagination.
	 *
	 * @param pageable pagination information
	 * @return a list of clients for the given page
	 */
	@Override
	public List<Client> findAll(Pageable pageable) {

		return clientRepository.findAll(pageable).toList();
	}

}