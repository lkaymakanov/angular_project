--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.25
-- Dumped by pg_dump version 9.5.5

-- Started on 2020-02-19 16:54:11

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = public, pg_catalog;

--
-- TOC entry 2053 (class 0 OID 24676)
-- Dependencies: 176
-- Data for Name: payment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO payment (payment_id, reservation_id, paytime, sum, pay_card_id) VALUES (4, 14, '2020-02-19 00:00:00', 20.00, 455151551);


--
-- TOC entry 2055 (class 0 OID 24694)
-- Dependencies: 178
-- Data for Name: promotion; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO promotion (promotion_id, expire_date, service_id, discount) VALUES (1, '2020-03-03', 3, 10);
INSERT INTO promotion (promotion_id, expire_date, service_id, discount) VALUES (2, '2020-03-03', 5, 15);
INSERT INTO promotion (promotion_id, expire_date, service_id, discount) VALUES (3, '2020-03-03', 8, 50);
INSERT INTO promotion (promotion_id, expire_date, service_id, discount) VALUES (4, '2020-03-03', 12, 10);
INSERT INTO promotion (promotion_id, expire_date, service_id, discount) VALUES (5, '2020-03-03', 16, 10);


--
-- TOC entry 2060 (class 0 OID 24755)
-- Dependencies: 183
-- Data for Name: reservation; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO reservation (reservation_id, reservation_date, service_id, user_id, reservationfor) VALUES (14, '2020-02-19', 3, 8, '2020-02-19 00:00:00');
INSERT INTO reservation (reservation_id, reservation_date, service_id, user_id, reservationfor) VALUES (15, '2020-02-19', 3, 8, '2020-02-19 00:00:00');
INSERT INTO reservation (reservation_id, reservation_date, service_id, user_id, reservationfor) VALUES (16, '2020-02-19', 1, 8, '2020-02-19 00:00:00');


--
-- TOC entry 2072 (class 0 OID 0)
-- Dependencies: 174
-- Name: s_payment; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('s_payment', 4, true);


--
-- TOC entry 2073 (class 0 OID 0)
-- Dependencies: 184
-- Name: s_promotion; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('s_promotion', 8, true);


--
-- TOC entry 2074 (class 0 OID 0)
-- Dependencies: 185
-- Name: s_reservation; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('s_reservation', 16, true);


--
-- TOC entry 2075 (class 0 OID 0)
-- Dependencies: 175
-- Name: s_service; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('s_service', 26, true);


--
-- TOC entry 2076 (class 0 OID 0)
-- Dependencies: 179
-- Name: s_service_group; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('s_service_group', 6, true);


--
-- TOC entry 2077 (class 0 OID 0)
-- Dependencies: 173
-- Name: s_services; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('s_services', 1, false);


--
-- TOC entry 2078 (class 0 OID 0)
-- Dependencies: 181
-- Name: s_user_data; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('s_user_data', 16, true);


--
-- TOC entry 2054 (class 0 OID 24684)
-- Dependencies: 177
-- Data for Name: service; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO service (service_id, name, service_group_id, price) VALUES (1, 'Face cleaning', 1, 40.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (2, 'Face, neck and neck lift', 1, 50.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (3, 'Facial massage', 1, 20.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (4, 'Photon face therapy', 1, 20.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (5, 'SPA face therapy', 1, 30.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (6, 'Diamond microdermabrasion', 1, 50.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (7, 'Anti-cellulite procedure ( ultrasonic cavitation )', 1, 30.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (8, 'Oxygen therapy (bio lifting + cryotherapy + mask)', 1, 50.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (9, 'Therapy against the broad pores', 1, 30.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (10, 'Eyebrow shaping', 1, 50.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (11, 'Optional therapy (according to client needs)', 1, 50.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (12, 'Car full-face mask', 2, 40.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (13, 'Car mask on hands', 2, 15.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (14, 'Bikini Car Mask', 2, 15.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (15, 'Car mask on the upper lip', 2, 5.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (16, 'Car armpit mask', 2, 5.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (17, 'Gel construction', 3, 65.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (18, 'Gel on natural nail', 3, 30.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (19, 'Gel support with two decorations', 3, 35.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (20, 'Gel Download', 3, 45.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (21, 'Gel polish', 3, 15.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (22, 'Gel polish remover', 3, 25.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (23, 'Simple manicure', 3, 50.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (24, 'With plain lacquer', 4, 28.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (25, 'With gel lacquer', 4, 35.00);
INSERT INTO service (service_id, name, service_group_id, price) VALUES (26, 'Classical massage', 5, 80.00);


--
-- TOC entry 2057 (class 0 OID 24705)
-- Dependencies: 180
-- Data for Name: service_group; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO service_group (service_group_id, service_group_name) VALUES (1, 'COSMETIC TREATMENTS');
INSERT INTO service_group (service_group_id, service_group_name) VALUES (2, 'WAXING');
INSERT INTO service_group (service_group_id, service_group_name) VALUES (3, 'MANICURE');
INSERT INTO service_group (service_group_id, service_group_name) VALUES (4, 'PEDICURE');
INSERT INTO service_group (service_group_id, service_group_name) VALUES (5, 'MASSAGES');


--
-- TOC entry 2059 (class 0 OID 24747)
-- Dependencies: 182
-- Data for Name: stuff; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO stuff (stuff_id, name, phone, image, description, user_id, work_hours, likes, dislikes) VALUES (3, 'Angelika', '+35987546575', 'image3.jpg', 'Lorem ipsum dolor sit amet 
consectetur adipisicing elit.Nam non voluptas doloreslaudantium. Nam eaque dignissimos eius itaque. 
Non reiciendis eum temporibus, porro cumque voluptatem quo consequatur aut magnam ea!', 6, '10:00-18:00', 342, 23);
INSERT INTO stuff (stuff_id, name, phone, image, description, user_id, work_hours, likes, dislikes) VALUES (1, 'Merry', '+35986876844', 'image1.png', 'Lorem ipsum dolor sit amet consectetur adipisicing elit.Nam non voluptas
 doloreslaudantium. Nam eaque dignissimos eius itaque. Non reiciendis eum temporibus, porro cumque voluptatem quo consequatur aut magnam ea!', 4, '10:00-18:00', 2321, 45);
INSERT INTO stuff (stuff_id, name, phone, image, description, user_id, work_hours, likes, dislikes) VALUES (2, 'Antonia', '+35967745434', 'image2.jfif', 'Lorem ipsum dolor sit amet 
consectetur adipisicing elit.Nam non voluptas doloreslaudantium. Nam eaque dignissimos eius itaque. 
Non reiciendis eum temporibus, porro cumque voluptatem quo consequatur aut magnam ea!', 5, '9:00-17:00', 21566, 14);


--
-- TOC entry 2063 (class 0 OID 24765)
-- Dependencies: 186
-- Data for Name: user_data; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO user_data (user_id, username, email, created_date, password, image) VALUES (8, 'bat_lubo2001@abv.bg', 'bat_lubo2001@abv.bg', '2020-02-18 00:00:00', 'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413', NULL);


-- Completed on 2020-02-19 16:54:11

--
-- PostgreSQL database dump complete
--

