// Example Landing Page with Backend Integration
// Place this in your React project and adapt to your needs

import React, { useState, useEffect } from 'react';
import PrintCard from '../components/printCard';
import { ticketsAPI } from '../services/api';

function LandingWithBackend() {
  const [tickets, setTickets] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    fetchTickets();
  }, []);

  const fetchTickets = async () => {
    try {
      setLoading(true);
      const response = await ticketsAPI.getMyTickets();
      
      if (response.data.success) {
        setTickets(response.data.data);
      }
    } catch (error) {
      const message = error.response?.data?.message || 'Erreur lors du chargement des tickets';
      setError(message);
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return (
      <div className="container mx-auto p-4">
        <div className="text-center py-8">
          <p className="text-gray-600">Chargement des tickets...</p>
        </div>
      </div>
    );
  }

  if (error) {
    return (
      <div className="container mx-auto p-4">
        <div className="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded">
          {error}
        </div>
      </div>
    );
  }

  return (
    <div className="container grid grid-cols-1 md:grid-cols-2 xl:grid-cols-3 2xl:grid-cols-4 gap-4">
      {tickets.length === 0 ? (
        <div className="col-span-full text-center py-8">
          <p className="text-gray-600">Aucun ticket trouvé</p>
        </div>
      ) : (
        tickets.map((ticket) => (
          <PrintCard
            key={ticket.id}
            id={ticket.id}
            title={ticket.title}
            description={ticket.fileType}
            name={ticket.actProf}
            actProf={ticket.actProf}
            totalNumber={ticket.totalNumber}
            createdDate={ticket.createdDate}
            status={ticket.status}
          />
        ))
      )}
    </div>
  );
}

export default LandingWithBackend;
