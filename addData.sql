INSERT INTO `the-farmer-project`.Adresse (codePost, pays, ville, voie, nom, numero, mention, complement)
VALUES
    ('75000', 'France', 'Paris', 'rue', 'de la paix', '1', '', ''),
    ('37000', 'France', 'Tours', 'Avenue', 'Grammont', '2', '', ''),
    ('49400', 'France', 'Saumur', 'quai', 'Comte Lair', '38', '', ''),
    ('49390', 'France', 'Vernoil-le-Fourrier', 'rue', 'de la Mairie', '14', '', ''),
    ('01630', 'France', 'Saint-Genis-Pouilly', 'Rue', 'des Hautains', '6Bis', '', ''),
    ('01250', 'France', 'Journans', 'Rue', 'de boissellores', '103', '', ''),
    ('69540', 'France', 'Lyon', 'Rue', 'Robert Schumann', '1', '', ''),
    ('84480', 'France', 'Paris', 'Avenue', 'Victor Hugo', '2', '', ''),
    ('53800', 'France', 'Marseille', 'Boulevard', 'Henri Dunant', '3', '', ''),
    ('76540', 'France', 'Lille', 'Rue', 'Charles de Gaulle', '4', '', ''),
    ('35000', 'France', 'Rennes', 'Avenue', 'Gustave Eiffel', '5', '', ''),
    ('67600', 'France', 'Strasbourg', 'Rue', 'Albert Schweitzer', '6', '', ''),
    ('43800', 'France', 'Toulouse', 'Avenue', 'Antoine de Saint-Exupéry', '7', '', ''),
    ('78150', 'France', 'Le Vésinet', 'Boulevard', 'Marie Curie', '8', '', ''),
    ('65340', 'France', 'Bordeaux', 'Rue', 'Louis Pasteur', '9', '', ''),
    ('47360', 'France', 'Nantes', 'Avenue', 'Henri Matisse', '10', '', ''),
    ('59540', 'France', 'Toulouse', 'Rue', 'Jeanne d Arc', '1', '', ''),
    ('74520', 'France', 'Marseille', 'Avenue', 'Napoléon Bonaparte', '2', '', ''),
    ('67350', 'France', 'Bordeaux', 'Boulevard', 'Edith Piaf', '3', '', ''),
    ('83520', 'France', 'Le Vésinet', 'Rue', 'Marie Curie', '4', '', ''),
    ('56860', 'France', 'Strasbourg', 'Avenue', 'Molière', '5', '', ''),
    ('50660', 'France', 'Nantes', 'Rue', 'Victor Hugo', '6', '', ''),
    ('89400', 'France', 'Paris', 'Avenue', 'Henri Dunant', '7', '', ''),
    ('54360', 'France', 'Lyon', 'Boulevard', 'Robert Schumann', '8', '', ''),
    ('79320', 'France', 'Lille', 'Rue', 'Charles de Gaulle', '9', '', ''),
    ('65750', 'France', 'Rennes', 'Avenue', 'Gustave Eiffel', '10', '', ''),
    ('29560', 'France', 'Toulouse', 'Rue', 'Antoine de Saint-Exupéry', '11', '', ''),
    ('59340', 'France', 'Marseille', 'Boulevard', 'Albert Schweitzer', '12', '', ''),
    ('78810', 'France', 'Le Vésinet', 'Rue', 'Marie Curie', '13', '', ''),
    ('73520', 'France', 'Strasbourg', 'Avenue', 'Molière', '14', '', ''),
    ('56340', 'France', 'Nantes', 'Rue', 'Victor Hugo', '15', '', '');

INSERT INTO `the-farmer-project`.Client (nomClient, prenomClient, numTel, gps, idAdresse)
VALUES
    ('Dupont', 'Jean', '0612345678', '48.8534, 2.3488', 1),
    ('Durand', 'Marie', '0698765432', '43.2964, 5.3700', 2),
    ('Martin', 'Luc', '0701234567', '45.7578, 4.8351', 3),
    ('Petit', 'Annie', '0654789012', '46.5286, 6.5729', 4),
    ('Leclerc', 'Eric', '0624681012', '48.8566, 2.3515', 5),
    ('Lefebvre', 'Sophie', '0613579246', '44.8379, 0.5795', 6),
    ('Roux', 'Patrick', '0681594720', '47.3901, 0.6893', 7),
    ('David', 'Brigitte', '0630258419', '47.8518, 1.9050', 8),
    ('Girard', 'Michel', '0698521470', '47.9845, 0.2180', 9),
    ('Robert', 'Claire', '0678945612', '47.2184, -1.5536', 10),
    ('Noir', 'François', '0636987410', '49.4521, 1.1095', 11),
    ('Dumont', 'Laure', '0601478523', '48.8600, 2.3370', 12),
    ('Garnier', 'Olivier', '0680245613', '48.8656, 2.3522', 13),
    ('Leroy', 'Charlotte', '0659872140', '48.8708, 2.3372', 14),
    ('Moreau', 'Marc', '0697412586', '48.8710, 2.4222', 15),
    ('Perrin', 'Céline', '0612354789', '48.8760, 2.3080', 16),
    ('Picard', 'Denis', '0612345678', '48.8760, 2.3580', 17),
    ('Roger', 'Nathalie', '0612345678', '48.8760, 2.3680', 18),
    ('Simon', 'Emilie', '0612345678', '48.8760, 2.3780', 19),
    ('Tessier', 'Julien', '0612345678', '48.8760, 2.3880', 20),
    ('Vincent', 'Aurélie', '0612345678', '48.8760, 2.3980', 21),
    ('Bertrand', 'Benjamin', '0612345678', '48.8760, 2.4080', 22),
    ('Dupuy', 'Alice', '0612345678', '48.8760, 2.4180', 23),
    ('Fournier', 'Arnaud', '0612345678', '48.8760, 2.4280', 24),
    ('Gauthier', 'Séverine', '0612345678', '48.8760, 2.4380', 25);

INSERT INTO `the-farmer-project`.Producteur (SIRET, mail, nomProd, prenomProd, numTel, mdp, idAdresse)
VALUES
    ('98765432123456', 'abc@gmail.com', 'Dupont', 'Marie', '0612345678', '1234', 26),
    ('12345678901234', 'abc@gmail.com', 'David', 'Martin', '0123456789', '1234', 27),
    ('14702583691247', 'abc@gmail.com', 'Nguyen', 'Anaïs', '0567898123', '1234', 28),
    ('91827364509876', 'abc@gmail.com', 'Rousseau', 'Thomas', '0345678901', '1234', 29),
    ('45612378902345', 'abc@gmail.com', 'Dubois', 'Emma', '0234567890', '1234', 30);

INSERT INTO `the-farmer-project`.Vehicule (immat, poidsMax, SIRET)
VALUES
    ('DE-548-HG', 200, '98765432123456'),
    ('RT-456-RG', 50, '12345678901234'),
    ('TH-467-RG', 500, '12345678901234'),
    ('RG-436-JU', 100, '14702583691247'),
    ('JU-490-RG', 100, '91827364509876'),
    ('PQ-456-TH', 100, '91827364509876'),
    ('RG-499-TH', 100, '45612378902345');

INSERT INTO `the-farmer-project`.Commande (libelle, poids, dateCom, heureDeb, heureFin, SIRET, idClient, numTournee)
VALUES
    ('Restaurant Y', 50, '2023-12-01', '10:00:00', '12:00:00', '98765432123456', 1, '')
