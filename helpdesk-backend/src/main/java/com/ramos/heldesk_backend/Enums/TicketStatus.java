package com.ramos.heldesk_backend.Enums;

public enum TicketStatus {
    OPEN, //Ticket abierto aun no tomado
    IN_PROGRESS, //Tciket tomado y en proceso de solución
    WAITING_CLIENT, //Ticket en espera de que el cliente proporcione mas información
    RESOLVED, //Ticket resueltos
    CLOSED // Ticket cerrado
}
