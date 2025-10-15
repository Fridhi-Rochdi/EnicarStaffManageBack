// API Service Configuration for React Frontend
// Place this file in your React project: src/services/api.js

import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api';

// Create axios instance
const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
});

// Request interceptor to add token
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem('token');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// Response interceptor to handle errors
api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401) {
      // Redirect to login if unauthorized
      localStorage.removeItem('token');
      window.location.href = '/';
    }
    return Promise.reject(error);
  }
);

// Auth API
export const authAPI = {
  login: (credentials) => api.post('/auth/login', credentials),
  register: (userData) => api.post('/auth/register', userData),
  getCurrentUser: () => api.get('/auth/me'),
};

// Tickets API
export const ticketsAPI = {
  getAllTickets: () => api.get('/tickets'),
  getMyTickets: () => api.get('/tickets/my-tickets'),
  getTicketById: (id) => api.get(`/tickets/${id}`),
  
  createTicket: (ticketData, file) => {
    const formData = new FormData();
    formData.append('ticket', new Blob([JSON.stringify(ticketData)], { type: 'application/json' }));
    if (file) {
      formData.append('file', file);
    }
    return api.post('/tickets', formData, {
      headers: { 'Content-Type': 'multipart/form-data' },
    });
  },
  
  updateTicket: (id, ticketData, file) => {
    const formData = new FormData();
    formData.append('ticket', new Blob([JSON.stringify(ticketData)], { type: 'application/json' }));
    if (file) {
      formData.append('file', file);
    }
    return api.put(`/tickets/${id}`, formData, {
      headers: { 'Content-Type': 'multipart/form-data' },
    });
  },
  
  updateTicketStatus: (id, status) => api.patch(`/tickets/${id}/status?status=${status}`),
  deleteTicket: (id) => api.delete(`/tickets/${id}`),
};

// File Types Constants
export const FILE_TYPES = [
  { value: 'COURS', label: 'Cours' },
  { value: 'TRAVEAUX_DIRIGES', label: 'Traveaux Dérigés' },
  { value: 'TRAVEAUX_PRATIQUES', label: 'Traveaux Pratiques' },
  { value: 'COURS_INTEGRE', label: 'Cour Integré' },
  { value: 'EXAMEN', label: 'Examen' },
  { value: 'EXAMEN_INTELLIGENT', label: 'Examen Intelligent' },
];

// Ticket Status Constants
export const TICKET_STATUS = {
  EN_ATTENTE: 'En Attente',
  EN_COURS: 'En Cours',
  TERMINE: 'Terminé',
  ANNULE: 'Annulé',
};

export default api;
