# OOP-Final-Lab
Bien sûr, voici une version révisée du rapport technique, en commençant par une introduction au concept de hackathon pour ceux qui ne sont pas familiers avec ce terme :

---

# Rapport Technique: Projet Java pour un Scénario de Hackathon

## Introduction

Un hackathon est un événement où des programmeurs, designers, gestionnaires de projet et d'autres experts en informatique collaborent intensivement sur des projets de logiciels. Ces événements peuvent durer généralement entre un jour et une semaine. L'objectif est souvent de créer un logiciel fonctionnel ou de travailler sur des projets de développement logiciel intensifs et collaboratifs.

Ce rapport technique décrit la conception et la structure d'un projet Java destiné à gérer un hackathon. Le projet est basé sur un diagramme de classes qui modélise les différentes entités impliquées dans un hackathon, telles que les équipes, les étudiants, les membres du jury et les discours.

## Conception du Système

### Classes

Le cœur du système est représenté par le diagramme de classes suivant, qui décrit les entités principales et leurs relations :

1. **Hackathon**: Représente l'événement lui-même, avec des attributs tels que le nom, la date, le lieu, les équipes participantes et les sponsors.

2. **Equipe**: Chaque équipe est composée d'étudiants et travaille sur un projet. Les attributs incluent le nom de l'équipe, les membres et le projet sur lequel ils travaillent.

3. **Etudiant**: Représente les participants du hackathon. Chaque étudiant a des compétences, une université d'origine et est associé à une équipe.

4. **Jury**: Composé de plusieurs membres, le jury est responsable de l'évaluation des projets.

5. **MembreJury**: Chaque membre du jury a un rôle spécifique et des responsabilités, comme évaluer les projets ou organiser des sessions.

6. **Discours**: Les discours sont des présentations faites pendant le hackathon, souvent pour inspirer ou éduquer les participants.


