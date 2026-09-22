---

<h1 align="center">
  <img src="app/src/main/assets/logo.png" width="36">
  GetMediBD
</h1>


<p align="center">
  <img src="https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white" />
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
  <img src="https://img.shields.io/badge/Supabase-3ECF8E?style=for-the-badge&logo=supabase&logoColor=white" />
  <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white" />
  <img src="https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=black" />
  <img src="https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=git&logoColor=white" />
  <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white" />
</p>

<p align="center">
  <strong>Multi-Vendor Online Pharmacy Marketplace</strong>
</p>

<p align="center">
  An Android marketplace connecting customers with verified pharmacies 
</p>

<p align="center">
  <a href="#about">About</a> •
  <a href="#features">Features</a> •
  <a href="#technology-stack">Technology</a> •
  <a href="#setup">Setup</a> •
  <a href="#team-workflow">Team Workflow</a> •
  <a href="#development-roadmap">Roadmap</a>
</p>

---

## About

**GetMediBD** is an Android-based multi-vendor pharmacy marketplace designed to connect customers with verified pharmacies through a single platform.

Customers can discover medicines, compare pharmacy availability, upload prescriptions, place orders, make payments, and track their purchases.

Pharmacies can manage their products, inventory, orders, prescriptions, and sales through their own shop portal.

The platform contains five portals:

| Portal              | Description                                                                                          |
| ------------------- | ---------------------------------------------------------------------------------------------------- |
| **Customer**        | Browse medicines, compare pharmacies, order products, manage prescriptions and track orders          |
| **Shop / Pharmacy** | Manage pharmacy profile, medicines, inventory, orders and sales                                      |
| **Rider / Delivery**| Manage assigned deliveries, live route navigation, status updates, earnings, and proof of delivery  |
| **Admin**           | Manage marketplace operations, users, pharmacies, medicines and orders                               |
| **SuperAdmin**      | Manage administrators, permissions and system-wide configuration                                     |

---

# Features

## Customer Portal

* User registration and authentication
* Medicine search and discovery
* Medicine details
* Generic and brand-based search
* Pharmacy-based medicine availability
* Pharmacy price comparison
* Nearby pharmacy discovery
* Prescription upload (Camera & Gallery)
* Prescription OCR scanning (Tesseract OCR)
* AI-assisted prescription analysis & doctor handwriting recognition
* Intelligent medicine matching with pharmacy inventory
* Shopping cart
* Multi-pharmacy ordering
* Online payment
* Order history
* Order tracking
* Saved addresses
* Favourite medicines and pharmacies
* Ratings and reviews
* Notifications
* Medicine reordering

## Shop / Pharmacy Portal

* Pharmacy registration
* Pharmacy document submission
* Pharmacy verification
* Pharmacy profile management
* Medicine management
* Inventory management
* Stock management
* Price management
* Order management
* Prescription order handling
* Sales and earnings
* Customer reviews
* Notifications

## Rider / Delivery Portal

* Rider registration and profile management
* Identity and vehicle verification (NID, driving license, vehicle documents)
* Online / offline availability toggle
* Real-time delivery request alerts & acceptance/rejection
* Pharmacy order pickup verification (QR code / pickup OTP)
* Live turn-by-turn route navigation (Google Maps)
* Real-time GPS location tracking for customer and pharmacy
* Delivery status updates (Assigned, Picked Up, In Transit, Delivered)
* Proof of delivery (Delivery OTP verification, photo proof, digital signature)
* Cash-on-Delivery (COD) collection and remittance tracking
* Daily, weekly earnings summary and payout history
* Trip history and completed delivery logs
* Performance ratings and customer reviews
* Push notifications and system alerts

## Prescription OCR & AI Medicine Matching System

* **Tesseract OCR Engine:** Fast on-device optical character recognition to scan and extract text from printed prescriptions
* **Handwriting AI API Fallback:** AI Vision API integration to read and decipher complex handwritten doctor prescriptions when OCR confidence is low
* **Intelligent Medicine Matcher:** Robust string and fuzzy matching algorithm to cross-reference extracted medicine names, dosages, and strengths with the verified marketplace medicine catalog
* **Automated Availability & Cart Integration:** Automatically checks matched medicines against nearby pharmacy inventories with price comparison and instant cart addition

## Admin Portal

* Customer management
* Pharmacy management
* Pharmacy verification
* Medicine management
* Category management
* Order monitoring
* Prescription monitoring
* Payment management
* Commission management
* Complaint management
* Dispute management
* Reports
* Analytics

## SuperAdmin Portal

* Admin account management
* Admin permissions
* Role-based access control
* Platform configuration
* Marketplace configuration
* System monitoring
* Audit logs
* Security management
* System-wide analytics

---

# Technology Stack

### Mobile Application

<p>
  <img src="https://skillicons.dev/icons?i=java,androidstudio" />
</p>

* Java
* Android Studio
* Android SDK
* XML
* Material Design

### Backend & Database

<p>
  <img src="https://skillicons.dev/icons?i=supabase,postgresql" />
</p>

* Supabase Authentication
* Supabase PostgreSQL
* Supabase Storage
* Supabase Realtime

### Additional Services

<p>
  <img src="https://skillicons.dev/icons?i=firebase" />
</p>

* Firebase Cloud Messaging
* Google Maps & GPS Geolocation
* Tesseract OCR (On-device prescription scanning)
* AI Vision API (Doctor handwriting recognition & medicine extraction)
* Payment Gateway

### Development Tools

<p>
  <img src="https://skillicons.dev/icons?i=git,github" />
</p>

* Git
* GitHub
* GitHub Pull Requests

> **Infrastructure:** No VPS or Docker is required for the initial project setup.

---

# Setup

Follow these steps **only if the required development environment is not already installed**.

If your environment is already properly configured, **skip directly to [Clone the Project](#2-clone-the-project)**.

---

## 1. Download the Required Setup

The required development environment and setup files are provided through the team's Google Drive.

### Download

**[Download Required Setup — Google Drive](YOUR_GOOGLE_DRIVE_LINK)**

Download the complete setup package before starting the project.

The package contains the required software and files needed for the development environment.

> **Already installed and working?**
> Skip this step and continue with the repository setup.

---

## 2. Install the Required IDE (Neatbean)

Install the required software from the provided Google Drive package.

After installation:

1. Open neatbean.
2. Make sure neatbean starts correctly.

Do not create a new Android project.

---

## 3. Clone the Project

All five team members have already been added as **collaborators** to the repository.

Therefore, there is **no need to fork the repository**.

Clone the original repository directly:

```bash
git clone https://github.com/Naim-006/GetMediBD.git
```

Enter the project directory:

```bash
cd GetMediBD
```

### Repository

**GitHub:**
https://github.com/Naim-006/GetMediBD

---

## 4. Open the Project

Open neatbean.

Select:

```text
Open
```

Then select the cloned:

```text
GetMediBD
```

project folder.

Allow Android Studio to:

* Sync the project
* Download required dependencies
* Index the project
* Complete the initial build

After synchronization, run the application and make sure the project builds successfully.

---

# Team Workflow

The repository is shared by **5 developers**.

Each developer has their own development branch.

```text
                         main
                           |
        +------------------+------------------+
        |         |         |         |        |
     Branch 1  Branch 2  Branch 3  Branch 4  Branch 5
        |         |         |         |        |
        +---------+---------+---------+--------+
                           |
                    Pull Request
                           |
                        Review
                           |
                        Approved
                           |
                           v
                          main
```

---

# Branch Structure

The repository contains:

```text
main
├── member-1
├── member-2
├── member-3
├── member-4
└── member-5
```

Replace the example branch name with your actual assigned branch.

### `main`

`main` is the stable branch.

**Do not develop directly on `main`.**

### Assigned Branch

Every developer works on their own assigned branch.

---

# Development Process

## 1. Switch to Your Branch

```bash
git checkout your-branch
```

Example:

```bash
git checkout member-1
```

---

## 2. Get the Latest Changes

Before starting your work:

```bash
git pull
```

This ensures your branch has the latest available changes.

---

## 3. Develop Your Feature

Work on your assigned feature in Android Studio.

```text
Develop
   ↓
Test
   ↓
Fix
   ↓
Commit
   ↓
Push
```

Avoid making unrelated changes to other features.

---

## 4. Check Your Changes

```bash
git status
```

Review the files that were modified.

---

## 5. Add Changes

```bash
git add .
```

---

## 6. Commit Changes

Use a meaningful commit message.

```bash
git commit -m "Add customer login screen"
```

### Good examples

```bash
git commit -m "Add pharmacy registration"
```

```bash
git commit -m "Implement medicine search"
```

```bash
git commit -m "Add customer order history"
```

```bash
git commit -m "Fix pharmacy inventory update"
```

Avoid messages such as:

```text
update
done
changes
final
test
```

---

## 7. Push Your Branch

```bash
git push
```

For the first push of a new branch:

```bash
git push -u origin your-branch
```

---

# Pull Request & Code Review

After completing your feature:

1. Push your branch to GitHub.
2. Open the GetMediBD repository.
3. Select your branch.
4. Create a **Pull Request**.
5. Set the target branch to `main`.
6. Describe what you changed.
7. Request a code review.

### Pull Request Flow

```text
Your Branch
     |
     | git push
     v
  GitHub
     |
     | Pull Request
     v
 Code Review
     |
     +---- Changes Required
     |          |
     |          v
     |      Fix & Push
     |          |
     |          +------> Review
     |
     +---- Approved
                |
                v
           Merge → main
```

Do not merge unreviewed work into `main`.

If the reviewer requests changes, make the changes on the **same branch** and push again.

The existing Pull Request will automatically update.

---

# After a Pull Request Is Merged

After your feature has been merged into `main`, update your local repository.

```bash
git checkout main
git pull
```

Then return to your assigned branch:

```bash
git checkout your-branch
```

Update your branch with the latest `main`:

```bash
git merge main
```

If Git reports conflicts, resolve them before continuing development.

---

# Daily Git Commands

The normal development cycle is:

```bash
git checkout your-branch
git pull

# Develop your feature

git status
git add .
git commit -m "Describe your changes"
git push
```

Then:

```text
Pull Request
     ↓
Code Review
     ↓
Approval
     ↓
Merge into main
```

---

# Team Rules

### Do

* Pull before starting development.
* Work only on your assigned branch.
* Use meaningful commit messages.
* Test your feature before creating a Pull Request.
* Review Pull Requests when assigned.
* Keep `main` stable.
* Communicate before making major project-wide changes.

### Don't

* Do not directly push to `main`.
* Do not force push.
* Do not delete another developer's branch.
* Do not overwrite another developer's work.
* Do not commit API keys or passwords.
* Do not commit database credentials.
* Do not commit private tokens or secret configuration.
* Do not make unrelated changes inside another developer's feature.

Never use:

```bash
git push --force
```

unless explicitly instructed by the team leader.

---

# Backend

GetMediBD uses **Supabase** as its backend platform.

```text
                    Android App
                         |
                       Java
                         |
                  +------+------+
                  |   Supabase  |
                  +------+------+
                         |
        +----------------+----------------+
        |                |                |
     Auth          PostgreSQL         Storage
        |                |                |
        +----------------+----------------+
                         |
                     Realtime
```

Supabase provides:

* Authentication
* Database
* File storage
* Realtime functionality
* Backend infrastructure

Additional external services can be integrated when required.

---

# Project Roadmap

## Phase 1 — Foundation

* Android project setup
* Authentication
* User roles
* Database structure
* Navigation
* Basic UI

## Phase 2 — Marketplace

* Customer portal
* Pharmacy portal
* Medicine catalog
* Inventory
* Search
* Cart
* Orders

## Phase 3 — Advanced Features

* Rider / Delivery portal
* Prescription upload & Tesseract OCR scanning
* AI doctor handwriting recognition fallback
* Intelligent medicine matcher with catalog
* Pharmacy verification
* Payment integration
* Real-time GPS delivery tracking & proof of delivery
* Notifications
* Ratings and reviews

## Phase 4 — Management

* Admin portal
* SuperAdmin portal
* Reports
* Analytics
* Commission management
* Audit logs
* Advanced marketplace management

---

# Repository

<p align="center">
  <a href="https://github.com/Naim-006/GetMediBD">
    <img src="https://img.shields.io/badge/GitHub-GetMediBD-181717?style=for-the-badge&logo=github&logoColor=white" />
  </a>
</p>

---

<p align="center">
  <strong>GetMediBD</strong>
  <br>
  Multi-Vendor Online Pharmacy Marketplace
</p>
