CREATE TABLE `tb_authorities` (
  `id_auth` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `name_auth` VARCHAR(40)
);

CREATE TABLE `tb_user` (
  `id_user` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_auth` INTEGER,
  `name_user` VARCHAR(100),
  `lastname_user` VARCHAR(100),
  `email_user` VARCHAR(100),
  `pwd_user` VARCHAR(100),
  `active` BIT,
  `is_fully_created` BIT,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_customer` (
  `id_customer` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_user` INTEGER NOT NULL,
  `nickname_customer` VARCHAR(100),
  `birthday_customer` DATETIME NOT NULL,
  `marital_status_customer` VARCHAR(12) NOT NULL,
  `religion_customer` VARCHAR(45),
  `veg_vege_customer` BOOLEAN,
  `individual_needs_customer` VARCHAR(150),
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_form` (
  `id_form` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_customer` INTEGER NOT NULL,
  `is_finished_form` BOOLEAN,
  `title_form` VARCHAR(40),
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_social_media` (
  `id_social_media` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_customer` INTEGER NOT NULL,
  `name_social_media` VARCHAR(60),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_descendants` (
  `id_descendant` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_customer` INTEGER NOT NULL,
  `name_descendant` VARCHAR(60),
  `age_descendant` INTEGER,
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_description` (
  `id_desc` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_form` INTEGER NOT NULL,
  `best_place_desc` VARCHAR(180),
  `wknd_best_place_desc` VARCHAR(180),
  `miss_actual_house_desc` VARCHAR(180),
  `bool_actual_house_satisfaction` BOOLEAN,
  `actual_house_satisfaction_desc` VARCHAR(180),
  `job_desc` VARCHAR(30),
  `work_routine_desc` VARCHAR(180),
  `bool_work_at_home` BOOLEAN,
  `days_working_at_home` INTEGER,
  `bool_travels_for_work` BOOLEAN,
  `travels_for_work_desc` VARCHAR(45),
  `bool_pratice_sports` BOOLEAN,
  `practice_sports_desc` VARCHAR(100),
  `bool_travel` BOOLEAN,
  `travel_desc` VARCHAR(50),
  `bool_watch_tv` BOOLEAN,
  `watch_tv_desc` VARCHAR(200),
  `bool_read` BOOLEAN,
  `bool_book_read` BOOLEAN,
  `bool_tablet_read` BOOLEAN,
  `bool_pets` BOOLEAN,
  `pets_desc` VARCHAR(180),
  `bool_cook` BOOLEAN,
  `cook_desc` VARCHAR(180),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_experience` (
  `id_experience` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_form` INTEGER NOT NULL,
  `neutral_color_exp` VARCHAR(20),
  `lively_color_exp` VARCHAR(20),
  `like_to_feel_exp` VARCHAR(180),
  `house_meaning_exp` VARCHAR(180),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_building` (
  `id_building` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_form` INTEGER NOT NULL,
  `neighborhood_relationship_building` VARCHAR(180),
  `determining_factor_building` VARCHAR(180),
  `architectural_language_building` VARCHAR(180),
  `balcony_integration_building` VARCHAR(180),
  `building_manager_contact_building` VARCHAR(180),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_entrance_hall` (
  `id_entrance_hall` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_form` INTEGER NOT NULL,
  `bool_shoes_house_walking_entrance_hall` BOOLEAN,
  `bool_has_entrance_console_table_entrance_hall` BOOLEAN,
  `bool_want_entrance_console_table_entrance_hall` BOOLEAN,
  `bool_full_length_mirror_entrance_hall` BOOLEAN,
  `bool_familiar_with_electronic_locks_entrance_hall` BOOLEAN,
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_dining_room` (
  `id_dining_room` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_form` INTEGER NOT NULL,
  `dining_table_capacity_dining_room` INTEGER,
  `daily_meals_location_dining_room` VARCHAR(60),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_kitchen` (
  `id_kitchen` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_form` INTEGER NOT NULL,
  `color_type_kitchen` VARCHAR(30),
  `shape_type_kitchen` VARCHAR(30),
  `counter_top_material_kitchen` VARCHAR(30),
  `material_preference_kitchen` VARCHAR(30),
  `bool_wet_gutter_or_built_in_trash_can_kitchen` BOOLEAN,
  `bool_stove_kitchen` BOOLEAN,
  `bool_cooktop_kitchen` BOOLEAN,
  `bool_induction_kitchen` BOOLEAN,
  `bool_burners_kitchen` BOOLEAN,
  `bool_stove_on_counter_top_kitchen` BOOLEAN,
  `bool_stove_on_tower_kitchen` BOOLEAN,
  `fridge_type_kitchen` VARCHAR(60),
  `bool_separate_freezer_kitchen` BOOLEAN,
  `fridge_capacity_liters_kitchen` INTEGER,
  `current_storage_satisfaction_kitchen` VARCHAR(140),
  `dinner_capacity_kitchen` INTEGER,
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_toilet` (
  `id_toilet` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_form` INTEGER NOT NULL,
  `apartment_pattern_toilet` VARCHAR(180),
  `design_toilet` VARCHAR(50),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_living_room` (
  `id_living_room` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_form` INTEGER NOT NULL,
  `people_in_living_room` INTEGER,
  `bool_tv_is_important_living_room` BOOLEAN,
  `tv_inch_living_room` INTEGER,
  `equipment_living_room` VARCHAR(160),
  `bool_sofa_with_chaise_living_room` BOOLEAN,
  `bool_sofa_with_retractable_chaise_living_room` BOOLEAN,
  `bool_books_or_collection_living_room` BOOLEAN,
  `bool_used_daily_living_room` BOOLEAN,
  `receives_many_people_living_room` VARCHAR(100),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_laundry` (
  `id_laundry` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_form` INTEGER NOT NULL,
  `bool_built_in_sink_laundry` BOOLEAN,
  `bool_porcelain_sink_laundry` BOOLEAN,
  `bool_pet_food_and_bowls_stored_here_laundry` BOOLEAN,
  `bool_recycles_trash_laundry` BOOLEAN,
  `current_drying_rack_count_laundry` INTEGER,
  `drying_rack_sizes_laundry` DECIMAL(5,2),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_bathroom` (
  `id_bathroom` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_form` INTEGER NOT NULL,
  `bool_all_renovated_bathroom` BOOLEAN,
  `preferred_sink_shape_bathroom` VARCHAR(50),
  `preferred_flush_type_bathroom` VARCHAR(20),
  `bool_hygienic_shower_bathroom` BOOLEAN,
  `bool_bidet_bathroom` BOOLEAN,
  `bool_prefers_mixer_tap_bathroom` BOOLEAN,
  `bool_prefers_single_handle_bathroom` BOOLEAN,
  `bool_electric_towel_rack_bathroom` BOOLEAN,
  `bool_laundry_hamper_in_cabinet_bathroom` BOOLEAN,
  `bool_makeup_in_bathroom_mirror_bathroom` BOOLEAN,
  `bool_many_products_on_counter_bathroom` BOOLEAN,
  `bool_daily_use_of_hairdryer_bathroom` BOOLEAN,
  `bool_shower_niche_for_products_bathroom` BOOLEAN,
  `bool_current_storage_meets_needs_bathroom` BOOLEAN,
  `bool_desire_more_storage_space_bathroom` BOOLEAN,
  `bool_sauna_in_shower_bathroom` BOOLEAN,
  `bool_bathtub_bathroom` BOOLEAN,
  `bool_immersion_bathroom` BOOLEAN,
  `bool_hydro_bathroom` BOOLEAN,
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_reuse_appliances_in_kitchen` (
  `id_reuse_appliances_in_kitchen` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_kitchen` INTEGER,
  `name_reuse_appliances_in_kitchen` VARCHAR(30),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_new_appliances_in_kitchen` (
  `id_new_appliances_in_kitchen` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_kitchen` INTEGER,
  `link_new_appliances_in_kitchen` TEXT,
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_necessary_appliances_in_kitchen` (
  `id_necessary_appliances_in_kitchen` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `id_kitchen` INTEGER,
  `bool_store_small_visible_appliances` BOOLEAN,
  `bool_store_small_hidden_appliances` BOOLEAN,
  `name_necessary_appliances_in_kitchen` VARCHAR(45),
  `bool_used_daily_necessary_appliances_in_kitchen` BOOLEAN,
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_master_suite` (
  `id_master_suite` INTEGER PRIMARY KEY,
  `id_form` INTEGER NOT NULL,
  `bed_type_suite` VARCHAR(30),
  `bool_tv_in_master_suite` BOOLEAN,
  `bool_armchair_master_suite` BOOLEAN,
  `bool_bench_master_suite` BOOLEAN,
  `bool_reads_in_bed_master_suite` BOOLEAN,
  `bool_nightstand_drawer_master_suite` BOOLEAN,
  `bool_wood_headboard_preference_master_suite` BOOLEAN,
  `bool_fabric_headboard_preference_master_suite` BOOLEAN,
  `bool_full_length_mirror_in_master_suite` BOOLEAN,
  `current_closet_length_master_suite` DECIMAL(5,2),
  `current_clothes_rail_length_master_suite` DECIMAL(5,2),
  `current_shoe_pairs_count_master_suite` INTEGER,
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_descendants_suite` (
  `id_descendants_suite` INTEGER PRIMARY KEY,
  `id_form` INTEGER NOT NULL,
  `bed_type_suite` VARCHAR(30),
  `bool_tv_in_descendants_suite` BOOLEAN,
  `bool_child_study_in_descendants_suite` BOOLEAN,
  `bool_child_receives_friends_to_sleep_descendants_suite` BOOLEAN,
  `theme_descendants_suite` VARCHAR(30),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_home_office_suite` (
  `id_home_office_suite` INTEGER PRIMARY KEY,
  `id_form` INTEGER NOT NULL,
  `bed_type_suite` VARCHAR(30),
  `bool_needs_privacy` BOOLEAN,
  `bool_needs_space_for_books_documents_papers` BOOLEAN,
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_guests_suite` (
  `id_guests_suite` INTEGER PRIMARY KEY,
  `id_form` INTEGER NOT NULL,
  `bed_type_suite` VARCHAR(30),
  `closet_use_guests_suite` VARCHAR(45),
  `frequency_of_guests_guests_suite` VARCHAR(45),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_general_info` (
  `id_general_info` INTEGER PRIMARY KEY,
  `id_form` INTEGER NOT NULL,
  `reuse_general_info` VARCHAR(200),
  `additional_general_info` VARCHAR(200),
  `unlisted_furniture_or_equipment_general_info` VARCHAR(200),
  `avoidance_requests_general_info` VARCHAR(200),
  `plant_relationship_general_info` VARCHAR(50),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_style_and_moods` (
  `id_style_and_moods` INTEGER PRIMARY KEY,
  `id_form` INTEGER NOT NULL,
  `ambient_style_style_and_moods` VARCHAR(20),
  `ambient_style_description_style_and_moods` VARCHAR(180),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_context` (
  `id_context` INTEGER PRIMARY KEY,
  `id_form` INTEGER NOT NULL,
  `project_life_stage_significance_context` VARCHAR(200),
  `investment_expectation_context` VARCHAR(200),
  `project_duration_expectation_context` VARCHAR(200),
  `location_during_renovation_context` VARCHAR(200),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

CREATE TABLE `tb_necessary_appliances_in_laundry` (
  `id_necessary_appliances_in_laundry` INTEGER PRIMARY KEY,
  `id_laundry` INTEGER,
  `name_necessary_appliances_in_laundry` VARCHAR(45),
  `is_filled` BOOLEAN,
  `created_at` DATETIME,
  `updated_at` DATETIME,
  `deleted_at` DATETIME
);

ALTER TABLE `tb_user` ADD FOREIGN KEY (`id_auth`) REFERENCES `tb_authorities` (`id_auth`);

ALTER TABLE `tb_customer` ADD FOREIGN KEY (`id_user`) REFERENCES `tb_user` (`id_user`);

ALTER TABLE `tb_social_media` ADD FOREIGN KEY (`id_customer`) REFERENCES `tb_customer` (`id_customer`);

ALTER TABLE `tb_descendants` ADD FOREIGN KEY (`id_customer`) REFERENCES `tb_customer` (`id_customer`);

ALTER TABLE `tb_form` ADD FOREIGN KEY (`id_customer`) REFERENCES `tb_customer` (`id_customer`);

ALTER TABLE `tb_description` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_experience` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_general_info` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_style_and_moods` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_context` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_master_suite` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_descendants_suite` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_home_office_suite` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_guests_suite` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_building` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_bathroom` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_entrance_hall` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_living_room` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_dining_room` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_kitchen` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_laundry` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_toilet` ADD FOREIGN KEY (`id_form`) REFERENCES `tb_form` (`id_form`);

ALTER TABLE `tb_new_appliances_in_kitchen` ADD FOREIGN KEY (`id_kitchen`) REFERENCES `tb_kitchen` (`id_kitchen`);

ALTER TABLE `tb_reuse_appliances_in_kitchen` ADD FOREIGN KEY (`id_kitchen`) REFERENCES `tb_kitchen` (`id_kitchen`);

ALTER TABLE `tb_necessary_appliances_in_kitchen` ADD FOREIGN KEY (`id_kitchen`) REFERENCES `tb_kitchen` (`id_kitchen`);

INSERT INTO tb_authorities (id_auth, name_auth)
VALUES (1, 'ROLE_CUSTOMER');

INSERT INTO tb_authorities (id_auth, name_auth)
VALUES (2, 'ROLE_ADMIN');
