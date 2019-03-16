package info.esuarez.springwebcustomertracker.controller;

import info.esuarez.springwebcustomertracker.repository.CustomerDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    private MockMvc mvc;

    @Mock
    private CustomerDAO customerDAO;

    @InjectMocks
    private CustomerController customerController;

    @Test
    public void shouldReturnListCustomersTemplateName() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(customerController).build();

        MockHttpServletResponse response = mvc.perform(
                MockMvcRequestBuilders.get("/customer/list").accept(MediaType.ALL))
                .andReturn()
                .getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getForwardedUrl()).isEqualTo("list-customers");
    }
}