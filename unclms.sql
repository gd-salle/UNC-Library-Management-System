--
-- PostgreSQL database dump
--

-- Dumped from database version 16.1
-- Dumped by pg_dump version 16.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.book (
    id integer NOT NULL,
    title character varying(50) NOT NULL,
    author character varying(50) NOT NULL,
    genre character varying(25) NOT NULL,
    yearpublished character varying(10) NOT NULL,
    description character varying(150) DEFAULT 'No description been provided'::character varying
);


ALTER TABLE public.book OWNER TO postgres;

--
-- Name: book_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.book_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.book_id_seq OWNER TO postgres;

--
-- Name: book_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.book_id_seq OWNED BY public.book.id;


--
-- Name: courses; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.courses (
    course_id character varying(25) NOT NULL,
    course_name character varying(100) NOT NULL,
    dept_id character varying(10)
);


ALTER TABLE public.courses OWNER TO postgres;

--
-- Name: department; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.department (
    dept_id character varying(10) NOT NULL,
    dept_name character varying(100) NOT NULL
);


ALTER TABLE public.department OWNER TO postgres;

--
-- Name: studusers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.studusers (
    id integer NOT NULL,
    student_id character varying(20) NOT NULL,
    firstname character(20) NOT NULL,
    middlename character(20),
    lastname character(20),
    suffix character(5),
    unc_email character varying(255) NOT NULL,
    course character varying(255) NOT NULL,
    phone_num character varying(13) NOT NULL
);


ALTER TABLE public.studusers OWNER TO postgres;

--
-- Name: studusers_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.studusers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.studusers_id_seq OWNER TO postgres;

--
-- Name: studusers_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.studusers_id_seq OWNED BY public.studusers.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    student_id character varying(50) NOT NULL,
    first_name character varying(50) NOT NULL,
    middle_name character varying(50),
    last_name character varying(50) NOT NULL,
    suffix character varying(5),
    unc_email character varying(100) NOT NULL,
    phone_num character varying(20) NOT NULL,
    dept_id character varying(10),
    course_id character varying(50),
    user_type character varying(20),
    ez_name character varying(50),
    password text,
    librarycard_number character varying(20),
    yearlevel character varying(20)
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: book id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book ALTER COLUMN id SET DEFAULT nextval('public.book_id_seq'::regclass);


--
-- Name: studusers id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.studusers ALTER COLUMN id SET DEFAULT nextval('public.studusers_id_seq'::regclass);


--
-- Data for Name: book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.book (id, title, author, genre, yearpublished, description) FROM stdin;
10	Solo Leveling	Chung Mung	Manhwa	2020-12-12	\N
11	Testing Book	GD	Fantasy	0005-05-11	\N
12	Hello World	Hiho	Fiction	2013-11-11	\N
13	Hi Universe	GD	Horror	1111-11-11	\N
14	Northen Blade 2.0	IDK	Manhwa	1981-03-12	A well known swordsman from murim
\.


--
-- Data for Name: courses; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.courses (course_id, course_name, dept_id) FROM stdin;
STEM	Science, Technology, Engineering and Mathematics	SHS
ABM	Accountancy, Business and Management	SHS
GAS	General Academic	SHS
HE-FBS	Home Economics- Food and Beverage Services	SHS
ICT-CP	Information and Communications Technology- Computer Programming	SHS
HUMSS	Humanities and Social Science	SHS
BAPS	Bachelor of Arts in Political Science	CAS
BAAP	Bachelor of Arts in Psychology	CAS
BSBio	Bachelor of Science in Biology	CAS
BSES-Bio	Bachelor of Science in Environmental Science Major in Bio/Chem	CAS
ACT	Associate in Computer Technology	CCS
BLIS	Bachelor of Library and Information Science	CCS
BSCS	Bachelor of Science in Computer Science	CCS
BSIT	Bachelor of Science in Information Technology	CCS
BSCrim	Bachelor of Science in Criminology	CCJE
BSEd-English	Bachelor of Secondary Education Major in English	CE
BSEd-Filipino	Bachelor of Secondary Education Major in Filipino	CE
BSEd-Math	Bachelor of Secondary Education Major in Mathematics	CE
BSEd-Science	Bachelor of Secondary Education Major in Science	CE
BSEd-SocialStudies	Bachelor of Secondary Education Major in Social Studies	CE
BSNE-TDHHL	Bachelor of Special Needs Education Major in Teaching Deaf And Hard-of-Hearing Learners	CE
BSNE-TLVI	Bachelor of Special Needs Education Major in Teaching Learners W/ Visual Impairment	CE
TCP-MAPEH	Teacher Certificate Program-MAPEH	CE
BSArchi	Bachelor of Science in Architecture	CEA
BSCE	Bachelor of Science in Civil Engineering	CEA
BSEE	Bachelor of Science in Electrical Engineering	CEA
BSME	Bachelor of Science in Mechanical Engineering	CEA
BSAcc	Bachelor of Science in Accountancy	CBA
BSAIS	Bachelor of Science in Accounting Information System	CBA
BSBA-FM	Bachelor of Science in Business Administration Major in Financial Management	CBA
BSBA-MM	Bachelor of Science in Business Administration Major in Marketing Management	CBA
BSBA-DM	Bachelor of Science in Business Administration Major in Digital Marketing	CBA
BS-Entrep	Bachelor of Science in Entrepreneurship	CBA
BSHM	Bachelor of Science in Hospitality Management	CBA
BSTM	Bachelor of Science in Tourism Management	CBA
ETEEAP	Expanded Tertiary Education Equivalency and Accreditation Program	CBA
BSBA-HRM	Bachelor of Science in Business Administration Major in Human Resource Management	CBA
BSBA-OM	Bachelor of Science in Business Administration Major Operations Management	CBA
BSN	Bachelor of Science in Nursing	CN
NCII-CG	Caregiving NC II (7 Months)	CN
\.


--
-- Data for Name: department; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.department (dept_id, dept_name) FROM stdin;
KP	Kinder and Pre-School
EL	Elementary
JHS	Junior High School
SHS	Senior High School
CAS	College of Arts and Sciences
CCS	College of Computer Studies
CCJE	College of Criminal Justice Education
CE	College of Education
CEA	College of Engineering and Architecture
CBA	College of Business and Accountancy
CN	College of Nursing
GS	Graduate Studies
Law	School of Law
\.


--
-- Data for Name: studusers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.studusers (id, student_id, firstname, middlename, lastname, suffix, unc_email, course, phone_num) FROM stdin;
1	16-07984	Benedick            	Trinidad            	Clerigo             	     	benedick.clerigo@unc.edu.ph	BSIT	09093334396
3	12-12345	Gerardo             	Master              	Salle               	Jr   	gerardo.salle@unc.edu.ph	BSIT	09123456789
4	12-23456	Alliyah             	Dizon               	Sistual             	     	alliyah.sistual@unc.edu.ph	BSCS	0909
5	13-12345	Juan                	Ka                  	Tamad               	Jr.  	juan.tamad@unc.edu.ph	BSIT	09093334396
7	00-23456	Benedick            	Trinidad            	Clerigo             	     	benz.clerigo@unc.edu.ph	BSIT	09093334396
8	00-34567	GD                  	MAster              	Salle               	Sr   	gd.salle@unc.edu.ph	BSIT	09204702910
9	00-45678	Cedrick             	Aragdala            	Barbosa             	     	cedrick.barbosa@unc.edu.ph	BSIT	09213456789
10	00-56789	Blah                	                    	Blah                	     	blah.blah@unc.edu.ph	BSIT	09346325632
11	99-12345	Maria               	Mapalad             	Hermosa             	     	maria.hermosa@unc.edu.ph	BSIT	09345343243
12	99-23456	Mark Joseph         	Dizon               	Sistual             	     	mark.sistutal@unc.edu.ph	BSECE	09382659247
13	10-12345	Juluis Kim          	Trinidad            	Clerigo             	     	juliuskim.clerigo@unc.edu.ph	BSIT	09204702919
14	67-23452	Cicer Tristan       	Trinidad            	Clerigo             	     	cicero.clerigo@unc.edu.ph	BSIT	09345829572
15	89-34568	Hehe                	Gaga                	ka                  	     	hehe.ka@unc.edu.ph	BSIT	09374826482
16	98-83847	jeje                	Trinidad            	clerigo             	     	jeje.clerigo@unc.edu.ph	BSIT	09093334396
17	16-07988	Alia Fe             	                    	Guerila             	     	aliafe.guerila@unc.edu.ph	BSECE	0928394024
18	19-39608	SALLE               	JR,                 	GERARDO P.          	Jr.  	gerardojr.salle@gmail.com	BSIT	09157334112
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (student_id, first_name, middle_name, last_name, suffix, unc_email, phone_num, dept_id, course_id, user_type, ez_name, password, librarycard_number, yearlevel) FROM stdin;
11-11111	Joke	joke	joke		joke.joke@unc.edu.ph	0909-323-9493	CN	BSN	Student	Joke	1234	39458983130502	1st Year
14-07984	Julius Kim	Trinidad	Clerigo		juliuskim.clerigo@unc.edu.ph	0920-470-291	CN	BSN	Student	Kim	1234		4th Year
00-12345	John John	Smith	Doe		john.doe@unc.edu.ph	9093-334-39	CBA	BSTM	Student	john	12345		3rd Year
12-12345	Benedick	Trinidad	Clerigo	II	benedick.clerigos@unc.edu.ph	0909-333-439	CAS	BAAP	Student	Dsfr	123		1st Year
15-82943	Mj	Dizon	Sistual 		mj.sistual@unc.edu.ph	0909-333-4395	CCJE	BSCrim	Student	Mj	123		1st Year
78-38388	Alliyah	Dizon	Sistual		alliyah.sistual@unc.edu.ph	0909-329-3232	CN	BSN	Student	Alliyah	123		1st Year
16-07984	Benedick	Trinidad	Clerigo	II	benedick.clerigo@unc.edu.ph	0909-333-4396	CCS	BSIT	Student	Benz	123456	07622096544067	3rd Year
12-43235	Benz	Trinidad	Clerigo		benz.clerigo@unc.edu.ph	09093334396	CCJE	BSCrim	Student	Benj	123	25115237274415	1st Year
53-32453	Kim	Trinidad 	Clerigo		kim.clerigo@unc.edu.ph	0909-333-4396	CAS	BSBio	Student	Kim	123	10575064046833	4th Year
90-43432	hehe	hehe	heheh		hehe.hehe@unc.edu.ph	0909-334-396	CE	BSEd-Math	Student	hheh	hee32	52545969574119	4th Year
91-43432	hehe	hehe	heheh		hehe.hehew@unc.edu.ph	0909-334-396	CEA	BSCE	Student	hheh	123	62483943880452	5th Year
53-23254	Gerardo	Master	Salle	Jr	gerardo.salle@unc.edu.ph	0912-345-678	CE	BSNE-TDHHL	Student	Gd	1234	93194034253244	4th Year
73-23873	Jeje	mon	ka		jeje.ka@unc.edu.ph	0909-333-4358	CAS	BAPS	Student	jej	1231	34456270205644	1st Year
732-84829	Bio		Sock		bio.shock@unc.edu.ph	0909-666-6787	CAS	BAPS	Student	Bioshock	nbn hjbj	27133775345885	1st Year
72-84829	Bio		Sock		biso.shock@unc.edu.ph	0909-829-4893	CBA	BSAcc	Student	Bioshock	123	22544990824589	1st Year
16-07986	Benedick	Trinidad	Clerigo	II	benedicks.clerigo@unc.edu.ph	0909-348-3583	CN	BSN	Student	Benz	123	05730678918345	1st Year
16-07980	Benedicka	Trinidad	Clerigo		benedicka.clerigo@unc.edu.ph	0909-923-2392	CN	BSN	Student	Benz	123	76428033003433	1st Year
18-84958	Benz	Clerigo	Trinidad		benz.trinidad@unc.edu.ph	0908-472-6485	CEA	BSEE	Student	Benzzz	123	64184954300426	4th Year
17-83927	Benx	Benx	Clerigo		benx.clerigo@unc.edu.ph	0909-837-8364	CCJE	BSCrim	Student	benxz	12345	82156996603648	1st Year
67-34353	Mj	Mj	Mj		mj.mj@unc.edu.ph	0948-538-2742	CCJE	BSCrim	Student	Mj	12345	22058121960887	4th Year
73-48384	Kill	kill	kill		kill.kill@unc.edu.ph	0909-374-7294	CCS	BSIT	Student	kill	1234	48508741548180	4th Year
83-48583	Veve	Veve	Veve		veve.veve@unc.edu.ph	0989-373-6583	CCJE	BSCrim	Student	Veve	veve	89861779541295	3rd Year
70-38478	gege	gegee	egeg		gege.egeg@unc.edu.ph	0902-384-7492	CCJE	BSCrim	Student	Gege	gege	83889878334277	3rd Year
17-34932	Hehe	hehehe	heehe		hehehehe.hehehe@unc.edu.ph	0923-284-3949	CE	BSEd-Math	Student	Hehe	12345	47714012716531	3rd Year
99-9999	Jesus	Holy	Christ		jesus.christ@unc.edu.ph	0934-839-4394	CCS	BSCS	Student	Jeudhs	1234	77479587498444	3rd Year
82-23828	Bio	Bio	Bio		bio.bio@unc.edu.ph	0982-382-3723	CEA	BSEE	Student	Bio	Bio123	83721578445093	3rd Year
77-77777	Bins	Bins	Bins		bins.bins@unc.edu.ph	0923-242-3232	CBA	BSBA-DM	Student	Bins	1234	86572180801097	3rd Year
44-44444	Ayaw	ayaw	ayaw		ayaw.ayaw@unc.edu.ph	0921-839-2382	CN	BSN	Student	ayaw	192129	54725426515408	1st Year
33-33333	Kilme	kill	kills		killme.kill@unc.edu.ph	0909-218-2833	CAS	BSBio	Student	KillYou	1234	79421902287300	2nd Year
29-34958	kiki	kiki	kiki		kiki@unc.edu.ph	09093334396	CBA	BSAcc	Student	Kiki	123	69868683910454	1st Year
16-01234	Benedick 	Trinidad 	Clerigo		trinidad.clerigo@unc.edu.ph	0909-333-4390	CAS	BSES-Bio	Student	Benedick	123456	65287484060088	3rd Year
18-34932	Cedrick	Aragdala	Barbosa		cedrick.barbosa@unc.edu.ph	0909-099-0909	CCS	BSCS	Student	Ced	123	07355206421289	3rd Year
18-92399	dhashdh	dhashdah	hhdashdhasd		sahdhahs@unc.edu.ph	09093334396	CEA	BSArchi	Student	hahh	ahsdhahdh	14434980220278	1st Year
17-09473	Beh	Beh	Beh		benh.beh@unc.edu.ph	0909-124-3863	CE	BSEd-SocialStudies	Student	Beh	123	59484278227574	1st Year
12-83933	Shain	Paralejo	Pachica		shaina.pachica@unc.edu.ph	0907-632-3636	CE	BSNE-TDHHL	Student	Shaina	123	02661224448943	3rd Year
\.


--
-- Name: book_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.book_id_seq', 14, true);


--
-- Name: studusers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.studusers_id_seq', 18, true);


--
-- Name: book book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.book
    ADD CONSTRAINT book_pkey PRIMARY KEY (id);


--
-- Name: courses courses_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (course_id);


--
-- Name: department department_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (dept_id);


--
-- Name: users students_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT students_pkey PRIMARY KEY (student_id);


--
-- Name: users students_unc_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT students_unc_email_key UNIQUE (unc_email);


--
-- Name: studusers studusers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.studusers
    ADD CONSTRAINT studusers_pkey PRIMARY KEY (id);


--
-- Name: studusers studusers_student_id_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.studusers
    ADD CONSTRAINT studusers_student_id_key UNIQUE (student_id);


--
-- Name: studusers studusers_unc_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.studusers
    ADD CONSTRAINT studusers_unc_email_key UNIQUE (unc_email);


--
-- Name: courses courses_dept_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_dept_id_fkey FOREIGN KEY (dept_id) REFERENCES public.department(dept_id);


--
-- Name: users students_course_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT students_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.courses(course_id);


--
-- Name: users students_dept_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT students_dept_id_fkey FOREIGN KEY (dept_id) REFERENCES public.department(dept_id);


--
-- PostgreSQL database dump complete
--

