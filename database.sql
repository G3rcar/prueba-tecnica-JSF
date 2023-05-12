/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  gerardo.calderon
 * Created: 05-11-2023
 */


CREATE TABLE "public"."blogs" (
    "id" serial,
    "title" varchar(50),
    "description" varchar(4000), 
PRIMARY KEY ("id"));

CREATE TABLE "public"."readers" (
    "id" serial,
    "name" varchar(20), 
PRIMARY KEY ("id"));

CREATE TABLE "public"."blogs_readers" (
    "id" serial,
    "r_id" int,
    "b_id" int, 
PRIMARY KEY ("id"));

ALTER TABLE "public"."blogs_readers" 
    ADD FOREIGN KEY ("r_id") 
    REFERENCES "public"."readers" ("id");

ALTER TABLE "public"."blogs_readers" 
    ADD FOREIGN KEY ("b_id") 
    REFERENCES "public"."blogs" ("id");


CREATE TABLE "public"."users" (
    "id" serial,
    "username" varchar(20),
    "password" varchar(80), 
PRIMARY KEY ("id"));