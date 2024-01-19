CREATE SEQUENCE booking_sequence START WITH 1000 INCREMENT BY 1;

CREATE TABLE booking (
	id					INT8 			DEFAULT nextval('booking_sequence'),
	booking_number		VARCHAR(255),
	status				VARCHAR(100),
	sender_name			VARCHAR(255),
	booking_type		VARCHAR(15),
	updated_at			TIMESTAMP,

	PRIMARY KEY(id),
	CONSTRAINT booking_number_uq UNIQUE (booking_number)
);

CREATE INDEX status_idx ON booking(status);
CREATE INDEX sender_name_idx ON booking(LOWER(sender_name));
CREATE INDEX updated_at_idx ON booking(updated_at);