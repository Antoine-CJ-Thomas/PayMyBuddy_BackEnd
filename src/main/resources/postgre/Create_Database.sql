
CREATE SEQUENCE public.user_account_id_seq;

CREATE TABLE public.user_account (
                id INTEGER NOT NULL DEFAULT nextval('public.user_account_id_seq'),
                email_address VARCHAR(64) NOT NULL,
                password VARCHAR(72) NOT NULL,
                first_name VARCHAR(32) NOT NULL,
                last_name VARCHAR(32) NOT NULL,
                balance NUMERIC(10,2) NOT NULL,
                CONSTRAINT user_account_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.user_account_id_seq OWNED BY public.user_account.id;

CREATE UNIQUE INDEX user_account_idx
 ON public.user_account
 ( email_address );

CREATE TABLE public.user_contact (
                user_id INTEGER NOT NULL,
                contact_id INTEGER NOT NULL,
                CONSTRAINT user_contact_pk PRIMARY KEY (user_id, contact_id)
);


CREATE TABLE public.internal_transaction (
                user_id INTEGER NOT NULL,
                contact_id INTEGER NOT NULL,
                date_time TIMESTAMP NOT NULL,
                amount NUMERIC(10,2) NOT NULL,
                description VARCHAR(40),
                CONSTRAINT internal_transaction_pk PRIMARY KEY (user_id, contact_id, date_time)
);


CREATE SEQUENCE public.bank_account_id_seq;

CREATE TABLE public.bank_account (
                id INTEGER NOT NULL DEFAULT nextval('public.bank_account_id_seq'),
                user_id INTEGER NOT NULL,
                account_name VARCHAR(20) NOT NULL,
                account_number VARCHAR(20) NOT NULL,
                swift_code VARCHAR(20) NOT NULL,
                CONSTRAINT bank_account_pk PRIMARY KEY (id)
);


ALTER SEQUENCE public.bank_account_id_seq OWNED BY public.bank_account.id;

CREATE UNIQUE INDEX bank_account_idx
 ON public.bank_account
 ( user_id, account_name );

CREATE TABLE public.external_transaction (
                user_id INTEGER NOT NULL,
                bank_id INTEGER NOT NULL,
                date_time TIMESTAMP NOT NULL,
                amount NUMERIC(10,2) NOT NULL,
                description VARCHAR(40),
                CONSTRAINT external_transaction_pk PRIMARY KEY (user_id, bank_id, date_time)
);


ALTER TABLE public.bank_account ADD CONSTRAINT user_bank_account_fk
FOREIGN KEY (user_id)
REFERENCES public.user_account (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.internal_transaction ADD CONSTRAINT user_transaction_fk1
FOREIGN KEY (user_id)
REFERENCES public.user_account (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.user_contact ADD CONSTRAINT user_relation_fk
FOREIGN KEY (user_id)
REFERENCES public.user_account (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.user_contact ADD CONSTRAINT user_relation_fk1
FOREIGN KEY (contact_id)
REFERENCES public.user_account (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.internal_transaction ADD CONSTRAINT user_transaction_fk
FOREIGN KEY (contact_id)
REFERENCES public.user_account (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.external_transaction ADD CONSTRAINT user_external_transaction_fk
FOREIGN KEY (user_id)
REFERENCES public.user_account (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.external_transaction ADD CONSTRAINT bank_account_external_transaction_fk
FOREIGN KEY (bank_id)
REFERENCES public.bank_account (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
