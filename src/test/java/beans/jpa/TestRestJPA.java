package beans.jpa;

import beans.Utils;
import beans.jpa.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TestRestJPA {

    @Autowired
    MockMvc mvc;

    @Autowired
    ItemRepository repository;

    @BeforeEach
    public void before() {
        repository.deleteAll();
    }

    @Test
    public void testReadCreateReadUpdateDelete() throws Exception {

        // read
        mvc.perform(get("/item"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        // read
        mvc.perform(get("/item/{id}", "3"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("no item found for 3"));

        // create
        {
            String content = Utils.readFile("input/TestRestJPA_testReadCreateReadUpdateDelete_CREATE.json");
            mvc.perform(put("/item")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(content))
                    .andExpect(status().isOk())
                    .andExpect(content().string(""));
        }

        // read
        {
            String content = Utils.readFile("output/TestRestJPA_testReadCreateReadUpdateDelete_AFTER_CREATE.json");
            mvc.perform(get("/item/{id}", "3"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(content().json(content));
        }

        // update
        {
            String content = Utils.readFile("input/TestRestJPA_testReadCreateReadUpdateDelete_UPDATE.json");
            mvc.perform(patch("/item")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(content))
                    .andExpect(status().isOk())
                    .andExpect(content().string(""));
        }

        // read
        {
            String content = Utils.readFile("output/TestRestJPA_testReadCreateReadUpdateDelete_AFTER_UPDATE.json");
            mvc.perform(get("/item/{id}", "3"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                    .andExpect(content().json(content));
        }

        // delete
        mvc.perform(delete("/item/{id}", "3")).andExpect(status().isOk());

        // read
        mvc.perform(get("/item"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

    }

}
