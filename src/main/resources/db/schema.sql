SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `bank_id` bigint UNSIGNED NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content_md` mediumtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `difficulty` tinyint NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `bank_id`(`bank_id` ASC) USING BTREE,
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`bank_id`) REFERENCES `question_bank` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for question_bank
-- ----------------------------
DROP TABLE IF EXISTS `question_bank`;
CREATE TABLE `question_bank`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1; 