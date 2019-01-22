create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

create table message (
    id bigint not null,
    filename varchar(255),
    tag TEXT,
    text TEXT,
    user_id bigint,
    primary key (id));

create table user_role (
    user_id bigint not null,
    roles varchar(255));

create table user_subscriptions (
      subscriber_id bigint not null,
      channel_id bigint not null,
      primary key (channel_id, subscriber_id));

create table usr (
    id bigint not null,
    activation_code varchar(255),
    active bit not null,
    email varchar(255),
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id));

alter table message
    add constraint message_user_fk
    foreign key (user_id) references usr (id);

alter table user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr (id);

alter table user_subscriptions
    add constraint user_subscriptions_channel_id_fk
    foreign key (channel_id) references usr (id);

alter table user_subscriptions
    add constraint user_subscriptions_subscriber_id_fk
    foreign key (subscriber_id) references usr (id);
