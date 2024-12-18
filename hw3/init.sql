create table tasks
(
    id             bigserial primary key,
    title          varchar,
    description    varchar,
    created_at     timestamp,
    owner_username varchar
)