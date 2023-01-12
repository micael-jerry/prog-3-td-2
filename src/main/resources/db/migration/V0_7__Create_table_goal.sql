create table goal
(
    id            integer primary key,
    play_again_id integer references play_again ("id"),
    player_id     integer references player ("id"),
    time          integer not null check ( time >= 0 and time <= 90),
    on_goal       boolean not null
);
