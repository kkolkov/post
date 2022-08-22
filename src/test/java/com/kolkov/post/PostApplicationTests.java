package com.kolkov.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kolkov.post.dto.ArrivalDto;
import com.kolkov.post.dto.RegistrationDto;
import com.kolkov.post.model.DispatchType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import javax.transaction.Transactional;

@SpringBootTest
@AutoConfigureMockMvc
class EndpointsAvailabilityTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void getStatusShouldBeAvailable() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders
						.request(HttpMethod.POST, "http://localhost:8080/status/get/{id}", 1))
				.andExpect(status().isOk());
	}

	@Test
	@Transactional
	void registerNewDispatchShouldBeAvailable() throws Exception {
		RegistrationDto newDispatch = new RegistrationDto("Петров Николай",
				193000, "ул. Петродворцовая д.1 кв. 1", DispatchType.бандероль);

		mockMvc.perform(MockMvcRequestBuilders
						.request(HttpMethod.POST, "http://localhost:8080/register/new")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(newDispatch)))
				.andExpect(status().isOk());
	}

	@Test
	@Transactional
	void registerDispatchArrivalShouldBeAvailable() throws Exception {
		ArrivalDto newArrival = new ArrivalDto(2L);

		mockMvc.perform(MockMvcRequestBuilders
						.request(HttpMethod.POST, "http://localhost:8080/register/arrival")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(newArrival)))
				.andExpect(status().isOk());
	}

	@Test
	@Transactional
	void registerDispatchDepartureShouldBeAvailable() throws Exception {
		ArrivalDto newArrival = new ArrivalDto(2L);

		mockMvc.perform(MockMvcRequestBuilders
						.request(HttpMethod.POST, "http://localhost:8080/register/departure")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(newArrival)))
				.andExpect(status().isOk());
	}

	@Test
	@Transactional
	void registerDispatchReceivingShouldBeAvailable() throws Exception {
		ArrivalDto newArrival = new ArrivalDto(2L);

		mockMvc.perform(MockMvcRequestBuilders
						.request(HttpMethod.POST, "http://localhost:8080/register/receiving")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(newArrival)))
				.andExpect(status().isOk());
	}
}