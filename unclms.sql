PGDMP      )                 |            unclms    16.1    16.1     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    24589    unclms    DATABASE        CREATE DATABASE unclms WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_Philippines.1252';
    DROP DATABASE unclms;
                postgres    false            �            1259    24670    courses    TABLE     �   CREATE TABLE public.courses (
    course_id character varying(25) NOT NULL,
    course_name character varying(100) NOT NULL,
    dept_id character varying(10)
);
    DROP TABLE public.courses;
       public         heap    postgres    false            �            1259    24664 
   department    TABLE     ~   CREATE TABLE public.department (
    dept_id character varying(10) NOT NULL,
    dept_name character varying(100) NOT NULL
);
    DROP TABLE public.department;
       public         heap    postgres    false            �            1259    24680    users    TABLE     E  CREATE TABLE public.users (
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
    DROP TABLE public.users;
       public         heap    postgres    false            �          0    24670    courses 
   TABLE DATA           B   COPY public.courses (course_id, course_name, dept_id) FROM stdin;
    public          postgres    false    216   �       �          0    24664 
   department 
   TABLE DATA           8   COPY public.department (dept_id, dept_name) FROM stdin;
    public          postgres    false    215   �       �          0    24680    users 
   TABLE DATA           �   COPY public.users (student_id, first_name, middle_name, last_name, suffix, unc_email, phone_num, dept_id, course_id, user_type, ez_name, password, librarycard_number, yearlevel) FROM stdin;
    public          postgres    false    217   �       $           2606    24707    courses courses_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_pkey PRIMARY KEY (course_id);
 >   ALTER TABLE ONLY public.courses DROP CONSTRAINT courses_pkey;
       public            postgres    false    216            "           2606    24668    department department_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.department
    ADD CONSTRAINT department_pkey PRIMARY KEY (dept_id);
 D   ALTER TABLE ONLY public.department DROP CONSTRAINT department_pkey;
       public            postgres    false    215            &           2606    24684    users students_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.users
    ADD CONSTRAINT students_pkey PRIMARY KEY (student_id);
 =   ALTER TABLE ONLY public.users DROP CONSTRAINT students_pkey;
       public            postgres    false    217            (           2606    24686    users students_unc_email_key 
   CONSTRAINT     \   ALTER TABLE ONLY public.users
    ADD CONSTRAINT students_unc_email_key UNIQUE (unc_email);
 F   ALTER TABLE ONLY public.users DROP CONSTRAINT students_unc_email_key;
       public            postgres    false    217            )           2606    24675    courses courses_dept_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.courses
    ADD CONSTRAINT courses_dept_id_fkey FOREIGN KEY (dept_id) REFERENCES public.department(dept_id);
 F   ALTER TABLE ONLY public.courses DROP CONSTRAINT courses_dept_id_fkey;
       public          postgres    false    216    215    4642            *           2606    24713    users students_course_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.users
    ADD CONSTRAINT students_course_id_fkey FOREIGN KEY (course_id) REFERENCES public.courses(course_id);
 G   ALTER TABLE ONLY public.users DROP CONSTRAINT students_course_id_fkey;
       public          postgres    false    4644    216    217            +           2606    24687    users students_dept_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.users
    ADD CONSTRAINT students_dept_id_fkey FOREIGN KEY (dept_id) REFERENCES public.department(dept_id);
 E   ALTER TABLE ONLY public.users DROP CONSTRAINT students_dept_id_fkey;
       public          postgres    false    217    215    4642            �     x��VMs�0=�_�c;7ǞmE��`��nz�E�PkK�$3��w%�wRN̠��~h��eŊ���;R��*�����0��
�H�!\դ�n-wRب��Y�Q"���J !�-�Њo���1)�GP`xC�kh���ie�VlL�Z�A'��6@J0;)�;�ULWQ������
`�۶WR�쨚�u�CVFoo[,��ע��}˕tٗZH�t�K��ɪ�R.��hC��$�Y"Y��b���'���v/�!��L�� *�G# +�`��I����9����<H�S�����*J��E�@>u�ܲ�R��/�^���}hҸ���=���T��@����"���N��F����L��_�o`�P7�n/I�sW��X�f�ܷ#�s��u߯pb%�"��>^��±y�9u�(�t}��2�Z���dq��e�K�r	P۷�*@�w��8M7u��q<X��/FQ/��A�Z��=y��GR�v\��O����HV,�瓂qr����1 B>�A�����oy�'�MΩ��fl��M2X��&8�5����=\M���'�9{|D� �'�{ ��_���:�=��&񼘴��#�Ը��:s�N
S��>zbN����7� d������r#]�w0��9ݴ��S��fo�Vv+�L$Ӷ��_�PM�*�i��V1�O�ӡ�C�˄q��w/w�A�Ã��o����5�fϷ�0���,&���z�Q��3|0\�.�$�x'�&��%��>F���2� -)�s��3)�r[��þ��f� 4,      �   �   x�e��j!���@�Y6!��":uܱ�J���nJ���?��o�LP��o�o֯9'�/jN�!W'XNV-�)�>Q\�/�=��/6�U&��u�ԓԲ����=0f &o_����@�|� ����V*y�sh�U�f���48#
qܫL�W��ks졕n˳��}n��`���ڤ�G���Bs�>pqw�<Ə�/�x�oFM{      �     x��W�n�H|������J��Yd,`_h�kR��R�����!J��]%j�gj�����{ܽ�l՛hS2��4_�/ぇDI��}d��G6���v�� ��Lm|�J(n�d���~γ�F脻�5{<��C}��ܰ�ܖ�l�f�*_w@�?���t��:=��v<�A�����L������ޒa�M�/��.�Xl����Ex��t��M' x~�hk6d�Z�^�c�o�e�x���={i윪�qU*ф:���d�G�����"i/�V�i��ʟ;�U��C��el�J����a���=\�UY��NA�O�W޳�z]�ȊS$Ʋ��u4�E�����%���
�5-\D��{X���I�e�Y)y�Fkn�I.5�l��ǵ	��נ���c���J#���I��0G��Nj�ؐ�G�t8q�*g>-w�`�g��\[�ԑd©%+�"?��ŏ��8"����e�O`A��<ǖFm��i!� S���/@���>$��z�� ��CdQ�F�wy�U�{��}^�9�7g�{m�5�8F9�\�|�����������ݲQ��D�\ii�E}���w�=櫜m�������-��H�[	�4?
O�G0�Q��qɍБ�J&^C���w�{)�U��#$k-y��HX������X���tB)�"���d�E��$�L���Uu�X�1#C�+����H�Ӈ�:[4d��Q��䁁*
������������v?H��0R��Y-=W�����#�G��#>�!�Gh�i�^��z�L�X��5��?��@[-B[K{,c�pK:z�{c���W��ꋢH+[Ef^
cC���it�:$L������6�S$��(�@T�/Z` ��)���?�)���C�^Cl;mJf\GN'=x�h��(�7��?��@��p���ʿ�þ¦dN�<���Ʋ��_\L��.+�C�D��&&�{�_�hr�������y(iA�t��w�>�F�����n�K)u:��K<}�m�Z�?�1DOr���&7l���h�5$�x ����և�=��?ج�0����V��W���1(s�]VgGa|�ˢn��F��Y�+P��K�{�$v�(�x���⋷�Ɣl�%� P����������m�ڶNɌ��e;�E�N����u�[H�=<�u���&?�o,�M�)�3D�I9׺�N�	te2P�����x%7���uC�M~��89��.C���ݡMaА.%�3�Ln[/if�*�V���Ցo��>К(� $�� 0���n�u��Kc_'翛�x���<zܷ�v��j���C�T�-Ug����'U�����f�ˮ�̲h~I_����@o����M_u��!iGc��:��e��Ųh?�BKw�����[1����A$ѤZ�q8̊�a-��Bc�DG�nPjP*�LiS̒ݛ�S�����U!!Nު^�0��ٚ@˼�L���K�0
P%��:/�r�>eU��W;|�����Y���>;�K,F>e��2��]�&��Z!1�b���;����K�y	     