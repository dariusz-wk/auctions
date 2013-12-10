create table AM_CONTACT (AUCTION_ID bigint not null, BANK varchar(255), BANK_ACCOUNT_NB varchar(16), EMAIL varchar(255), LOGIN varchar(255), NAME varchar(255), PHONE varchar(255), SURNAME varchar(255), primary key (AUCTION_ID))
create table AUCTION (AUCTION_ID bigint generated by default as identity (start with 1), AUCTION_OWNER varchar(255), AUCTION_CURRENT_PRICE double, AUCTION_DELIVERY_DESC varchar(255), AUCTION_DESC varchar(255), AUCTION_END timestamp, AUCTION_START timestamp, AUCTION_START_PRICE double, AUCTION_TITLE varchar(255), AUCTION_FINALIZED bit, AUCTION_FINISHED bit, AUCTION_WON bit, primary key (AUCTION_ID))
create table BET (BET_ID bigint generated by default as identity (start with 1), BET_PRICE double, BET_TIME timestamp, CLIENT_ID varchar(255), AUCTION_ID bigint not null, primary key (BET_ID))
create table BUYER_CONTACT (AUCTION_ID bigint not null, ADDRESS varchar(255), EMAIL varchar(255), LOGIN varchar(255), NAME varchar(255), PHONE varchar(255), SURNAME varchar(255), primary key (AUCTION_ID))
create table IMAGE (IMG_ID bigint generated by default as identity (start with 1), URL varchar(255), AUCTION_ID bigint not null, primary key (IMG_ID))
alter table BET add constraint BET_AUCTION_FK foreign key (AUCTION_ID) references AUCTION
alter table IMAGE add constraint IMAGE_AUCTION_FK foreign key (AUCTION_ID) references AUCTION