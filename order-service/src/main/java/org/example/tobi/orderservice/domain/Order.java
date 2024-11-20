package org.example.tobi.orderservice.domain;

import org.springframework.data.relational.core.mapping.Table;

@Table("orders")
public record Order() {
}
