package com.hanye.info.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("groceryitems")
public class GroceryItem {

        @Id
        private String id;
        private String name;
        private String category;
        
}