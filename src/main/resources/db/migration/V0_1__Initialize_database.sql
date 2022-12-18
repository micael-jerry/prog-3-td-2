create table team
(
    id   integer primary key,
    name varchar(80) not null
        constraint team_name_unique unique
);

create table player
(
    id      integer primary key,
    team_id integer references team ("id"),
    name    varchar(100),
    number  integer
        constraint player_number_limitation check ( number > 0 and number < 100)
);

create table sponsor
(
    id   integer primary key,
    name varchar(100) not null
        constraint sponsor_name_unique unique
);

create table have
(
    team_id    integer references team ("id"),
    sponsor_id integer references sponsor ("id"),
    primary key (team_id, sponsor_id)
);

create table play_again
(
    id        integer primary key,
    team1_id integer references team ("id") not null
        constraint team_play_again check ( team1_id != team2_id ),
    team2_id integer references team ("id") not null,
    datetime  date,
    stadium   varchar(100)
);