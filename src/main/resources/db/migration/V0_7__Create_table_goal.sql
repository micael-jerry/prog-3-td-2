create table goal
(
    id            integer primary key,
    play_against_id integer references play_against ("id"),
    player_id     integer references player ("id"),
    time          integer not null check ( time >= 0 and time <= 90),
    on_goal       boolean not null
);
