PGDMP  &                    {            unclms    16.1    16.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24589    unclms    DATABASE        CREATE DATABASE unclms WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Philippines.1252';
    DROP DATABASE unclms;
                postgres    false            �            1259    24591 	   studusers    TABLE     l  CREATE TABLE public.studusers (
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
    DROP TABLE public.studusers;
       public         heap    postgres    false            �            1259    24590    studusers_id_seq    SEQUENCE     �   CREATE SEQUENCE public.studusers_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.studusers_id_seq;
       public          postgres    false    216            �           0    0    studusers_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.studusers_id_seq OWNED BY public.studusers.id;
          public          postgres    false    215                       2604    24594    studusers id    DEFAULT     l   ALTER TABLE ONLY public.studusers ALTER COLUMN id SET DEFAULT nextval('public.studusers_id_seq'::regclass);
 ;   ALTER TABLE public.studusers ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215    216            �          0    24591 	   studusers 
   TABLE DATA           z   COPY public.studusers (id, student_id, firstname, middlename, lastname, suffix, unc_email, course, phone_num) FROM stdin;
    public          postgres    false    216   k       �           0    0    studusers_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.studusers_id_seq', 17, true);
          public          postgres    false    215                       2606    24596    studusers studusers_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.studusers
    ADD CONSTRAINT studusers_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.studusers DROP CONSTRAINT studusers_pkey;
       public            postgres    false    216                       2606    24598 "   studusers studusers_student_id_key 
   CONSTRAINT     c   ALTER TABLE ONLY public.studusers
    ADD CONSTRAINT studusers_student_id_key UNIQUE (student_id);
 L   ALTER TABLE ONLY public.studusers DROP CONSTRAINT studusers_student_id_key;
       public            postgres    false    216                        2606    24602 !   studusers studusers_unc_email_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.studusers
    ADD CONSTRAINT studusers_unc_email_key UNIQUE (unc_email);
 K   ALTER TABLE ONLY public.studusers DROP CONSTRAINT studusers_unc_email_key;
       public            postgres    false    216            �   2  x��Uˎ�0<��"?�?�طf�]F���^L���PB;_�v�$4H�:�*UW�!@�Q�I�a���0y}��{m��PE�8�tmև�W����s����X->n`�����%c�3�"��e<���U] �9�:����t4(�]�=n\K���J3!w��/W���6}��q�I��9��
�V7���=]v�Q����[5���MK� ��O�����Z|r�N9�8>k�_|�^ሻ���% m1���Kooq�Y�,���H:��e����`\�u��ިa��ա���6� x�[B��*;��;L�A������NX�W�Z�SF� B@�s��6����*�~�zwG�΁��oR'�a�"�Q�pY�2�}�'��E�ԥߢ�p�^���[�4��g���#��S՚&z3�O��{�V�mJ�{��KЬ�Ҭ�Najrd�ל�{�4}�@�-��2ɬ�	٭��>n���L�o.(C��?7�A�3n'nDR�b$��l���4(80o򥋄d�)a�k���:�w3��"W��+�[��Ō
&yL9��B���     