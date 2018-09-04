CREATE TABLE `ag_mono_ins` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `AG monoinsaturés (g/100g)` varchar(9) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Ag-mono-insatures';


CREATE TABLE `ag_poly` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `AG polyinsaturés (g/100g)` varchar(9) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='ag polysatures';


CREATE TABLE `ag_satures` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `AG saturés (g/100g)` varchar(9) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `amidon` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `Amidon (g/100g)` varchar(7) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `Autre` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `Energie (kcal/100g)` varchar(6) DEFAULT NULL,
  `Energie, avec fibres  (kJ/100g)` varchar(6) DEFAULT NULL,
  `Energie  avec fibres  (kcal/100g)` varchar(6) DEFAULT NULL,
  `Eau (g/100g)` varchar(5) DEFAULT NULL,
  `Fibres alimentaires (g/100g)` varchar(7) DEFAULT NULL,
  `Polyols totaux (g/100g)` varchar(8) DEFAULT NULL,
  `Alcool (g/100g)` varchar(6) DEFAULT NULL,
  `Acides organiques (g/100g)` varchar(8) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `cholesterol` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `Cholestérol (mg/100g)` varchar(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



















CREATE TABLE `proteines` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `Protéines (g/100g)` varchar(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `glucides` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `Glucides (g/100g)` varchar(6) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `lipides` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `Lipides (g/100g)` varchar(7) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

























CREATE TABLE `mineraux` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `Sel chlorure de sodium (g/100g)` varchar(8) DEFAULT NULL,
  `Calcium (mg/100g)` varchar(6) DEFAULT NULL,
  `Chlorure (mg/100g)` varchar(8) DEFAULT NULL,
  `Cuivre (mg/100g)` varchar(8) DEFAULT NULL,
  `Fer (mg/100g)` varchar(8) DEFAULT NULL,
  `Iode (µg/100g)` varchar(7) DEFAULT NULL,
  `Magnésium (mg/100g)` varchar(6) DEFAULT NULL,
  `Manganèse (mg/100g)` varchar(8) DEFAULT NULL,
  `Phosphore (mg/100g)` varchar(7) DEFAULT NULL,
  `Potassium (mg/100g)` varchar(6) DEFAULT NULL,
  `Sélénium (µg/100g)` varchar(6) DEFAULT NULL,
  `Sodium (mg/100g)` varchar(6) DEFAULT NULL,
  `Zinc (mg/100g)` varchar(8) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `omega_3` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `AG 18:3 c9,c12,c15 (n-3), alpha-linolénique (g/100g)` varchar(9) DEFAULT NULL,
  `AG 20:5 5c,8c,11c,14c,17c (n-3) EPA (g/100g)` varchar(10) DEFAULT NULL,
  `AG 22:6 4c,7c,10c,13c,16c,19c (n-3) DHA (g/100g)` varchar(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `omega_6` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `AG 18:2 9c,12c (n-6), linoléique (g/100g)` varchar(9) DEFAULT NULL,
  `AG 20:4 5c,8c,11c,14c (n-6), arachidonique (g/100g)` varchar(9) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


CREATE TABLE `omega_9` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `AG 18:1 9c (n-9), oléique (g/100g)` varchar(9) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



CREATE TABLE `sucres` (
  `FAMILLE D’ALIMENTS` varchar(43) DEFAULT NULL,
  `sous famille alimentaire` varchar(49) DEFAULT NULL,
  `sous famille alimentaire 2` varchar(44) DEFAULT NULL,
  `code produit` int(5) DEFAULT NULL,
  `aliment / produit` varchar(149) DEFAULT NULL,
  `Sucres (g/100g)` varchar(7) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;