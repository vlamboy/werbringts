package de.htwberlin.werbringts.web;

import de.htwberlin.werbringts.service.BringlistService;
import de.htwberlin.werbringts.web.api.Bringlist;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BringlistRestController.class)
public class BringlistRestControllerTest {

    @Autowired
    private MockMvc mockmvc;

    @MockBean
    private BringlistService bringlistService;

    @Test
    @DisplayName("should show a 201 http status when creating a bringlist")
    void statusCreateBringlist201() throws Exception {
        // Arrange
        String bringlistToCreateAsJson = "{\"listName\": \"Geburtstagsparty\", \"listDescription\": \"Am Freitag feiern wir meinen Geburtstag\", \"productId\": 16}";
        var bringlist = new Bringlist(42, null, null, null);
        doReturn(bringlist).when(bringlistService).create(any());
        // Act
    mockmvc.perform(
        post("/api/v1/bringlists")
                .contentType(MediaType.APPLICATION_JSON)
                .content(bringlistToCreateAsJson))
        // Assert
            .andExpect(status().isCreated())
            .andExpect(header().exists("Location"))
            .andExpect(header().string("Location", Matchers.equalTo(("/api/v1/bringlists/" + bringlist.getBringlistId()))));

    }
}
