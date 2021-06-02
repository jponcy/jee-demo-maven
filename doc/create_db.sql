DROP DATABASE "cours_enchere";
CREATE DATABASE "cours_enchere";
\c "cours_enchere"

CREATE SEQUENCE "app_articles_seq";
CREATE TABLE "app_articles" (
  "id" INTEGER DEFAULT nextval('app_articles_seq'),
  "nom" VARCHAR(50) NOT NULL,
  "description" TEXT NULL,
  "prix_depart" INTEGER NOT NULL, -- Prix en points.
  "prix_vente" INTEGER NULL,

  CONSTRAINT "pk_article"
    PRIMARY KEY("id"),
  CONSTRAINT "ck_prix_vente"
    CHECK ("prix_vente" >= "prix_depart")
);


INSERT INTO "app_articles" ("nom", "description", "prix_depart", "prix_vente")
  VALUES ('Table basse mR4ad5', 'Première vente', 50, 70);
INSERT INTO "app_articles" ("nom", "prix_depart")
  VALUES ('PC Gamer pour travailler', 210);
